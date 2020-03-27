package chapter8.item52;

import java.math.BigInteger;
import java.util.*;

// Repaired  static classifier method.
public class FixedCollectionClassifier {
  public static void main(String[] args) {
    Collection<?>[] collections = {
      new HashSet<String>(), new ArrayList<BigInteger>(), new HashMap<String, String>().values()
    };

    for (Collection<?> collection : collections) {
      System.out.println(classify(collection));
    }
  }

  private static String classify(Collection<?> collection) {
    return collection instanceof Set
        ? "Set"
        : collection instanceof List ? "List" : "Unknown Collection";
  }
}
