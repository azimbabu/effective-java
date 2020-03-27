package chapter6.item40;

import java.util.HashSet;
import java.util.Set;

public class Bigram {

  private final char first;
  private final char second;

  public Bigram(char first, char second) {
    this.first = first;
    this.second = second;
  }

  public static void main(String[] args) {
    Set<Bigram> bigrams = new HashSet<>();
    for (int i = 0; i < 10; i++) {
      for (char ch = 'a'; ch <= 'z'; ch++) {
        bigrams.add(new Bigram(ch, ch));
      }
    }
    System.out.println(bigrams.size());
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Bigram)) {
      return false;
    }

    Bigram b = (Bigram) o;
    return b.first == first && b.second == second;
  }

  @Override
  public int hashCode() {
    return 31 * first + second;
  }
}
