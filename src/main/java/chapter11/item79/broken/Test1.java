package chapter11.item79.broken;

import java.util.HashSet;

// Simple test of ObservableSet
public class Test1 {
  public static void main(String[] args) {
      ObservableSet<Integer> observableSet = new ObservableSet<>(new HashSet<>());
      observableSet.addObserver((set, element) -> System.out.println(element));
      for (int i=0; i < 100; i++) {
          observableSet.add(i);
      }
  }
}
