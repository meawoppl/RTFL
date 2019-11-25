package io.rtfl.detection.LanguageHacks;

public interface CommentFormat {
  /**
   * This returns true iff this line begins a multiline comment
   * This may include single line "mult-line" comments
   * /* stuff *\/
   * because that line also ends a multi-line comment
   *
   * @param line to test
   * @return boolean
   */
  boolean isStartOfMultilineComment(String line);

  /**
   * This returns true iff this line ends a multiline comment
   * This may include single line "mult-line" comments
   * /* stuff *\/
   * because that line also begins a multi-line comment
   *
   * @param line to test
   * @return boolean
   */
  boolean isEndOfMultilineComment(String line);

  /**
   * Return true iff this is a single line comment
   * @param line to test
   * @return boolean
   */
  boolean isSingleLineComment(String line);
}
