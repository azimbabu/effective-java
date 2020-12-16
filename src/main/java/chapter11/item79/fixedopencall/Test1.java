package chapter11.item79.fixedopencall;

import java.util.HashSet;

public class Test1 {
  public static void main(String[] args) {
    ObservableSet<Integer> observableSet = new ObservableSet<>(new HashSet<>());
    observableSet.addObserver((set, element) -> System.out.println(element));
    for (int i = 0; i < 100; i++) {
      observableSet.add(i);
    }
  }
}
