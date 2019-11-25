package io.rtfl.detection;

import io.rtfl.detection.LanguageHacks.CComment;
import io.rtfl.detection.LanguageHacks.CPPComment;
import io.rtfl.detection.LanguageHacks.CommentFormat;
import io.rtfl.detection.LanguageHacks.JavaComment;
import io.rtfl.detection.LanguageHacks.PythonComment;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is a class to pull out comments at the headers of a file
 * this logic will get gross/hairy without actual parsing/lexing,
 * but for the time being, this is out of scope
 */
public class HeaderCommentExtractor {
  public static final int HEADER_LINE_LIMIT = 200;

  private static final Map<String, CommentFormat> extensionMap;
  static {
    extensionMap = new HashMap<>();

    extensionMap.put("c", new CComment());
    extensionMap.put("h", new CComment());
    extensionMap.put("cpp", new CPPComment());
    extensionMap.put("py", new PythonComment());
    extensionMap.put("java", new JavaComment());
  }

  private final CommentFormat fmt;

  private HeaderCommentExtractor(CommentFormat fmt) {
    this.fmt = fmt;
  }

  public static HeaderCommentExtractor forExtension(String extension){
    extension = extension.toLowerCase();
    if(extensionMap.containsKey(extension)){
      return new HeaderCommentExtractor(extensionMap.get(extension));
    }
    throw new RuntimeException("No Comment Extractor for file extension: " + extension);
  }

  public List<String> extractHeaderLines(BufferedReader reader){
    List<String> headerLines = new ArrayList<>();

    boolean inMultilineComment = false;

    for (int i = 0; i < HEADER_LINE_LIMIT; i++) {
      String line;
      try {
        line = reader.readLine();
      } catch (IOException e){
        return headerLines;
      }

      if(line == null){
        break;
      }

      // Handle multi-line comment state
      if(inMultilineComment){
        if(fmt.isEndOfMultilineComment(line)){
          inMultilineComment = false;
        }
        headerLines.add(line);
        continue;
      }

      if(!inMultilineComment && fmt.isStartOfMultilineComment(line)){
        // Single line multi line comment does not change ml comment state
        if(!fmt.isEndOfMultilineComment(line)) {
          inMultilineComment = true;
        }
        headerLines.add(line);
        continue;
      }

      // Include whitespace, we can trim off leading/lagging later
      if(line.trim().equals("")){
        headerLines.add(line);
        continue;
      }

      // Single line comment
      if(fmt.isSingleLineComment(line)){
        headerLines.add(line);
        continue;
      }

      // If we made it here, we encountered non-comment/whitespace lines, so bail
      break;
    }

    // Pull off leading whitespace
    while(headerLines.size() != 0 && headerLines.get(0).equals("")){
      headerLines.remove(0);
    }

    // Pull off lagging whitespace
    while(headerLines.size() != 0 && headerLines.get(headerLines.size()-1).equals("")){
      headerLines.remove(headerLines.size()-1);
    }

    return headerLines;
  }
}
