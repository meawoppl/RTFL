package io.rtfl.detection.LanguageHacks;

public class CPPComment extends CComment {
  @Override
  public boolean isSingleLineComment(String line) {
    return startsWithIgnoringWS(line, "//");
  }
}
