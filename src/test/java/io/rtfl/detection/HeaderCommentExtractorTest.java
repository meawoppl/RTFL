package io.rtfl.detection;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;


public class HeaderCommentExtractorTest extends Assertions {

  @Test
  public void testConstructors(){
    HeaderCommentExtractor.forExtension("cpp");
    HeaderCommentExtractor.forExtension("java");
    HeaderCommentExtractor.forExtension("h");
    HeaderCommentExtractor.forExtension("c");
  }

  private BufferedReader getResource(String name) throws IOException {
    URL f = getClass().getClassLoader().getResource(name);
    if(f == null){
      throw new RuntimeException("No resource file named: " + name);
    }
    return Files.newBufferedReader(new File(f.getFile()).toPath());
  }

  private void gotFirstLineLastLine(List<String> lines){
    assertThat(lines.size()).isGreaterThan(0);
    assertThat(lines.get(0)).contains("firstline");
    assertThat(lines.get(lines.size()-1)).contains("lastline");

  }

  @Test
  public void testExtractionC() throws Exception {
    BufferedReader reader = getResource("HasHeader.c");
    HeaderCommentExtractor extractor = HeaderCommentExtractor.forExtension("c");
    List<String> lines = extractor.extractHeaderLines(reader);

    gotFirstLineLastLine(lines);
  }

  @Test
  public void testExtractionCPP() throws Exception {
    BufferedReader reader = getResource("HasHeader.cpp");
    HeaderCommentExtractor extractor = HeaderCommentExtractor.forExtension("cpp");
    List<String> lines = extractor.extractHeaderLines(reader);

    gotFirstLineLastLine(lines);
  }

  @Test
  public void testExtractionJava() throws Exception {
    BufferedReader reader = getResource("HasHeader.java");
    HeaderCommentExtractor extractor = HeaderCommentExtractor.forExtension("cpp");
    List<String> lines = extractor.extractHeaderLines(reader);

    gotFirstLineLastLine(lines);
  }
  @Test
  public void testExtractionPython() throws Exception {
    BufferedReader reader = getResource("HasHeader.py");
    HeaderCommentExtractor extractor = HeaderCommentExtractor.forExtension("py");
    List<String> lines = extractor.extractHeaderLines(reader);

    gotFirstLineLastLine(lines);
  }

}