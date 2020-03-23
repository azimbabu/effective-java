package chapter7.item46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FrequencyTable {
  public static void main(String[] args) throws FileNotFoundException {
      approach1(args[0]);

      // Proper use of streams to initialize a frequency table
      File file = new File(args[0]);
      Map<String, Long> frequency;
      try (Stream<String> words = new Scanner(file).tokens()) {
          frequency = words.collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
      }

      System.out.println(frequency);

      // Pipeline to get a top-ten list of words from a frequency table
      List<String> topTenWords = frequency.keySet().stream()
              .sorted(Comparator.comparing(frequency::get).reversed())
              .limit(10)
              .collect(Collectors.toList());

      System.out.println(topTenWords);
  }

    private static void approach1(String arg) throws FileNotFoundException {
        File file = new File(arg);

        // Uses the streams API but not the paradigm--Don't do this!
        Map<String, Long> frequency = new HashMap<>();
        try (Stream<String> words = new Scanner(file).tokens()) {
            words.forEach(word -> frequency.merge(word.toLowerCase(), 1L, Long::sum));
        }
    }
}
