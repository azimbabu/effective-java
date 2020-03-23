package chapter7.item48;

import java.math.BigInteger;
import java.util.stream.Stream;

// Parallel stream-based program to generate the first 20 Mersenne primes - HANGS!!!
public class ParallelMersennePrimes {
  static Stream<BigInteger> primes() {
    return Stream.iterate(BigInteger.TWO, BigInteger::nextProbablePrime);
  }

  public static void main(String[] args) {
    primes()
        .map(prime -> BigInteger.TWO.pow(prime.intValueExact()).subtract(BigInteger.ONE))
        .parallel()
        .filter(mersenne -> mersenne.isProbablePrime(50))
        .limit(20)
        .forEach(mp -> System.out.println(mp.bitLength() + ": " + mp));
  }
}
