package chapter7.item43;

import java.util.Map;
import java.util.TreeMap;

// Frequency table implemented with map.merge, using lambda and method reference
public class Frequency {

  public static void main(String[] args) {
      Map<String, Integer> frequencyTable = new TreeMap<>();

      for (String arg : args) {
          frequencyTable.merge(arg, 1, (count, increment) -> count + increment);
      }
      System.out.println(frequencyTable);

      frequencyTable.clear();
      for (String arg : args) {
          frequencyTable.merge(arg, 1, Integer::sum);
      }
      System.out.println(frequencyTable);
  }
}
