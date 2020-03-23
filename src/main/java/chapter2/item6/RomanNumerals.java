package chapter2.item6;

import java.util.regex.Pattern;

// Reusing expensive object for improved performance
public class RomanNumerals {
  // Reusing expensive object for improved performance
  private static final Pattern ROMAN =
      Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

  // Performance can be greatly improved!
  static boolean isRomanNumeralSlow(String s) {
    return s.matches("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
  }

  static boolean isRomanNumeralFast(String s) {
    return ROMAN.matcher(s).matches();
  }

  public static void main(String[] args) {
    int numSets = 10;
    int numRepetitions = 100;

    System.out.println("Demo Slow");
    for (int i = 0; i < numSets; i++) {
      long start = System.nanoTime();

      for (int j = 0; j < numRepetitions; j++) {
        isRomanNumeralSlow("MCMLXXVI");
      }

      long end = System.nanoTime();
      System.out.println((end - start) / (1000.0 * numRepetitions) + " μs.");
    }

    System.out.println("Demo Fast");
    for (int i = 0; i < numSets; i++) {
      long start = System.nanoTime();

      for (int j = 0; j < numRepetitions; j++) {
        isRomanNumeralFast("MCMLXXVI");
      }

      long end = System.nanoTime();
      System.out.println((end - start) / (1000.0 * numRepetitions) + " μs.");
    }
  }
}
