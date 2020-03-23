package chapter7.item45;

import java.math.BigInteger;
import java.util.stream.Stream;

// Generating the first twenty Mersenne primes using streams
public class MersennePrimes {
    static Stream<BigInteger> primes() {
        return Stream.iterate(BigInteger.TWO, BigInteger::nextProbablePrime);
    }

  public static void main(String[] args) {
        primes().map(prime -> BigInteger.TWO.pow(prime.intValueExact()).subtract(BigInteger.ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(mp -> System.out.println(mp.bitLength() + ": " + mp));
  }
}
