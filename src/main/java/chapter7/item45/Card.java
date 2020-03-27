package chapter7.item45;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Generating the Cartesian product of two lists using iteration and streams
public class Card {
  private static final List<Card> NEW_DECK_ITERATIVE = newDeckIterative();
  private static final List<Card> NEW_DECK_STREAM_BASED = newDeckStreamBased();
  private final Suit suit;
  private final Rank rank;

  public Card(Suit suit, Rank rank) {
    this.suit = suit;
    this.rank = rank;
  }

  private static List<Card> newDeckStreamBased() {
    return Stream.of(Suit.values())
        .flatMap(suit -> Stream.of(Rank.values()).map(rank -> new Card(suit, rank)))
        .collect(Collectors.toList());
  }

  private static List<Card> newDeckIterative() {
    List<Card> cards = new ArrayList<>();
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        cards.add(new Card(suit, rank));
      }
    }
    return cards;
  }

  public static void main(String[] args) {
    System.out.println(NEW_DECK_ITERATIVE);
    System.out.println(NEW_DECK_STREAM_BASED);
  }

  @Override
  public String toString() {
    return rank + " of " + suit + "S";
  }

  public enum Suit {
    SPADE,
    HEART,
    DIAMOND,
    CLUB
  }

  public enum Rank {
    ACE,
    DEUCE,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING
  }
}
