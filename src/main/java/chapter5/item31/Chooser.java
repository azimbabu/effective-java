package chapter5.item31;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Chooser<T> {

  private final List<T> choiceList;

  // Wildcard type for parameter that serves as an T producer
  public Chooser(Collection<? extends T> choices) {
    choiceList = new ArrayList<>(choices);
  }

  public static void main(String[] args) {
    List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);

    Chooser<Number> chooser = new Chooser<>(intList);

    for (int i = 0; i < 10; i++) {
      Number choice = chooser.choose();
      System.out.println(choice);
    }
  }

  public T choose() {
    Random random = ThreadLocalRandom.current();
    return choiceList.get(random.nextInt(choiceList.size()));
  }
}
