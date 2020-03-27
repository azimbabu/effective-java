package chapter8.item52;

import java.util.Arrays;
import java.util.List;

// Classification using method overriding
public class Overriding {
  public static void main(String[] args) {
    List<Wine> wines = Arrays.asList(new Wine(), new SparklingWine(), new Champagne());
    for (Wine wine : wines) {
      System.out.println(wine.name());
    }
  }
}
