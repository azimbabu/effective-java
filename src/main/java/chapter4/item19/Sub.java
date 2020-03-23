package chapter4.item19;

import java.time.Instant;

public class Sub extends Super {
  // Blank final, set by constructor
  private final Instant instant;

  public Sub() {
    instant = Instant.now();
  }

  // Overriding method invoked by superclass constructor

  public static void main(String[] args) {
    Sub sub = new Sub();
    sub.overrideMe();
  }

  @Override
  public void overrideMe() {
    System.out.println(instant);
  }
}
