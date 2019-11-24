package io.rtfl.detection;

import org.assertj.core.api.Assertions;
import org.junit.Test;


public class WordVectorTest extends Assertions {
  @Test
  public void testConstructors(){
    WordVector wv = WordVector.forString("foo bar foo");

    // assertThat()
    assertThat(wv.getCountFor("foo")).isEqualTo(2);
    assertThat(wv.getCountFor("bar")).isEqualTo(1);
    assertThat(wv.getCountFor("qux")).isEqualTo(0);
  }

  @Test
  public void testProbability(){
    WordVector wv = WordVector.forString("foo bar foo");

    // assertThat()
    assertThat(wv.probabilityOf("foo")).isEqualTo(2.0/3.0);
    assertThat(wv.probabilityOf("bar")).isEqualTo(1.0 / 3.0);
    assertThat(wv.probabilityOf("qux")).isEqualTo(0.0);
  }
}