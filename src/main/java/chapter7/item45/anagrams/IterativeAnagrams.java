package chapter7.item45.anagrams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// Prints all large anagram groups in a dictionary iteratively
public class IterativeAnagrams {
  public static void main(String[] args) throws FileNotFoundException {
    File dictionary = new File(args[0]);
    int minGroupSize = Integer.parseInt(args[1]);

    Map<String, Set<String>> groups = new HashMap<>();
    try (Scanner scanner = new Scanner(dictionary)) {
      while (scanner.hasNext()) {
        String word = scanner.next();
        groups.computeIfAbsent(alphabetize(word), unused -> new TreeSet<>()).add(word);
      }
    }

    for (Set<String> group : groups.values()) {
      if (group.size() >= minGroupSize) {
        System.out.println(group.size() + ": " + group);
      }
    }
  }

  private static String alphabetize(String word) {
    char[] chars = word.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }
}
