package chapter3.item14;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class WordList {

  public static void main(String[] args) {
    Set<String> set = new TreeSet<>();
    Collections.addAll(set, args);
    System.out.println(set);
  }
}
