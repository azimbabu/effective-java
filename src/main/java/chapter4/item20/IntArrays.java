package chapter4.item20;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

// Concrete implementation built atop skeletal implementation
public class IntArrays {
  static List<Integer> intArrayAsList(int[] a) {
    Objects.requireNonNull(a);

    // The diamond operator is only legal here in Java 9 and later
    // If you're using an earlier release, specify <Integer>
    return new AbstractList<>() {
      @Override
      public Integer get(int index) {
        return a[index]; // Autoboxing
      }

      @Override
      public Integer set(int index, Integer value) {
        int oldValue = a[index];
        a[index] = value; // Auto-unboxing
        return oldValue; // Autoboxing
      }

      @Override
      public int size() {
        return a.length;
      }
    };
  }
}
