/* firstline
 *
 * Cruft
 */

// single

/*
 * lastline */

package foo.bar.LanguageHacks;

public abstract class AbstractCommentFormat implements CommentFormat {
  protected static boolean startsWithIgnoringWS(String line, String start){
    return line.trim().startsWith(start);
  }

  protected static boolean endsWithIgnoringWhitespace(String line, String ending){
    return line.trim().endsWith(ending);
  }
}
