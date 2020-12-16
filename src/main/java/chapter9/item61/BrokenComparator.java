package chapter9.item61;

import java.util.Comparator;

// Broken comparator - can you spot the flaw?
public class BrokenComparator {
  public static void main(String[] args) {
    Comparator<Integer> naturalOrder = (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);
    int result = naturalOrder.compare(new Integer(42), new Integer(42));
    System.out.println(result);

    // Fixed comparator
    Comparator<Integer> naturalOrder2 =
        (iBoxed, jBoxed) -> {
          int i = iBoxed, j = jBoxed;
          return i < j ? -1 : (i == j ? 0 : 1);
        };
    int result2 = naturalOrder2.compare(new Integer(42), new Integer(42));
    System.out.println(result2);
  }
}
