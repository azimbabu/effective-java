package chapter8.item55;

import java.util.*;

public class Max {

    // Returns maximum value in collection - throws exception if empty
    public static <E extends Comparable<E>> E maxNullVersion(Collection<E> collection) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("Empty collection");
        }

        E result = null;
        for (E element : collection) {
            if (result == null || element.compareTo(result) > 0) {
                result = Objects.requireNonNull(element);
            }
        }
        return result;
    }

    // Returns maximum value in collection as an Optional<E>
    public static <E extends Comparable<E>> Optional<E> maxOptionalVersion(Collection<E> collection) {
        if (collection.isEmpty()) {
            return Optional.empty();
        }

        E result = null;
        for (E element : collection) {
            if (result == null || element.compareTo(result) > 0) {
                result = Objects.requireNonNull(element);
            }
        }
        return Optional.of(result);
    }

    // Returns max val in collection as Optional<E> - uses stream
    public static <E extends Comparable<E>> Optional<E> maxStreamVersion(Collection<E> collection) {
        return collection.stream().max(Comparator.naturalOrder());
    }

  public static void main(String[] args) {
      List<String> words = Arrays.asList("Hello", "World", "Hello1", "World1");

      System.out.println(maxNullVersion(words));

      // Using an optional to provide a chosen default value
      String lastWordInLexicon = maxOptionalVersion(words).orElse("No words...");
      System.out.println(lastWordInLexicon);
  }
}
