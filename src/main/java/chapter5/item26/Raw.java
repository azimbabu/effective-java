package chapter5.item26;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

// Fails at runtime - unsafeAdd method uses a raw type (List)!
public class Raw {
  public static void main(String[] args) {
    List<String> strings = new ArrayList<>();
    unsafeAdd(strings, Integer.valueOf(42));
    String s = strings.get(0); // Has compiler-generated cast
  }

  private static void unsafeAdd(List list, Object o) {
    list.add(o);
  }

  // Use of raw type for unknown element type
  static int numElementsInCommonRaw(Set s1, Set s2) {
    int result = 0;
    for (Object o : s1) {
      if (s2.contains(o)) {
        result++;
      }
    }
    return result;
  }

  // Uses unbounded wildcard type - typesafe and flexible
  static int numElementsInCommonUnbounded(Set<?> s1, Set<?> s2) {
    int result = 0;
    for (Object o : s1) {
      if (s2.contains(o)) {
        result++;
      }
    }
    return result;
  }
}
