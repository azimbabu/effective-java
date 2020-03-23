package chapter2.item6;

// Hideously slow program! Can you spot the object creation?
public class Sum {

  public static long sum() {
    long sum = 0L;

    for (long i = 0; i <= Integer.MAX_VALUE; i++) {
      sum += i;
    }

    return sum;
  }

  public static void main(String[] args) {
    int numRepetitions = 10;
    long total = 0;

    long start = System.nanoTime();

    for (int i = 0; i < numRepetitions; i++) {
      total += sum();
    }

    long end = System.nanoTime();
    System.out.println((end - start) / (1000.0 * numRepetitions) + " μs.");

    System.out.println("Total " + total);
  }
}
