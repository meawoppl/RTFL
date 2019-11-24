package io.rtfl.detection;

import com.google.common.collect.ImmutableMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is a map-like class that provides helpful functions for simple NPL
 * algorithm implementations.
 */
public class WordVector {
  private final ImmutableMap<String, Integer> vector;
  private final int wordCount;

  private WordVector(Map<String, Integer> vector) {
    this.vector = ImmutableMap.copyOf(vector);
    this.wordCount = vector.values().stream().mapToInt((v)->v).sum();
  }

  public static WordVector forWordList(List<String> words){
    Map<String, Integer> v = new HashMap<>();
    words.forEach((w)->v.put(w, v.getOrDefault(w, 0) + 1));
    return new WordVector(v);
  }

  public static WordVector forString(String words){
    return forWordList(Arrays.asList(words.split("\\s+")));
  }

  public Map<String, Integer> getVector() {
    return vector;
  }

  public int getCountFor(String word){
    return vector.getOrDefault(word, 0);
  }

  public double probabilityOf(String word){
    return ((double) getCountFor(word)) / (double) wordCount;
  }
}
