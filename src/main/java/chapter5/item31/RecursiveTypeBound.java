package chapter5.item31;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

// Using a recursive type bound with wildcards
public class RecursiveTypeBound {

  public static <T extends Comparable<? super T>> T max(List<? extends T> collection) {
    if (collection.isEmpty()) {
      throw new IllegalArgumentException("Empty collection");
    }

    T result = null;
    for (T e : collection) {
      if (result == null || e.compareTo(result) > 0) {
        result = Objects.requireNonNull(e);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    List<String> argList = Arrays.asList(args);
    System.out.println(max(argList));
  }
}
