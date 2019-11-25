package io.rtfl.detection.LanguageHacks;

public class PythonComment extends AbstractCommentFormat {
  @Override
  public boolean isSingleLineComment(String line) {
    return startsWithIgnoringWS(line,"#");
  }

  @Override
  public boolean isStartOfMultilineComment(String line) {
    return false;
  }

  @Override
  public boolean isEndOfMultilineComment(String line) {
    return false;
  }
}
