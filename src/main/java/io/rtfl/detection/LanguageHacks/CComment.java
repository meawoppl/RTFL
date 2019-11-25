package io.rtfl.detection.LanguageHacks;

public class CComment extends AbstractCommentFormat {
  @Override
  public boolean isSingleLineComment(String line) {
    return false;
  }

  @Override
  public boolean isStartOfMultilineComment(String line) {
    return startsWithIgnoringWS(line, "/*");
  }

  @Override
  public boolean isEndOfMultilineComment(String line) {
    return endsWithIgnoringWhitespace(line, "*/");
  }
}
