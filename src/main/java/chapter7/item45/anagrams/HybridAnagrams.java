package chapter7.item45.anagrams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HybridAnagrams {
  public static void main(String[] args) throws IOException {
    Path dictionary = Paths.get(args[0]);
    int minGroupSize = Integer.parseInt(args[1]);

    try (Stream<String> words = Files.lines(dictionary)) {
      words.collect(Collectors.groupingBy(word -> alphabetize(word))).values().stream()
          .filter(group -> group.size() >= minGroupSize)
          .forEach(group -> System.out.println(group.size() + ": " + group));
    }
  }

  private static String alphabetize(String word) {
    char[] chars = word.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }
}
