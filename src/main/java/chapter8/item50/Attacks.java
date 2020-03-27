package chapter8.item50;

import java.util.Date;

// Two attacks on the internals of an "immutable" period
public class Attacks {
  public static void main(String[] args) {
    attackDemo();

    // Attack the internals of a Period instance
    Date start = new Date();
    Date end = new Date();
    Period period = new Period(start, end);
    end.setYear(78); // Cannot modify internals of period!
    System.out.println(period);

    // Second attack on the internals of a Period instance
    start = new Date();
    end = new Date();
    period = new Period(start, end);
    period.end().setYear(78); // Modifies internals of period!
    System.out.println(period);
  }

  private static void attackDemo() {
    // Attack the internals of a PeriodBroken instance
    Date start = new Date();
    Date end = new Date();
    PeriodBroken period = new PeriodBroken(start, end);
    end.setYear(78); // Modifies internals of period!
    System.out.println(period);

    // Second attack on the internals of a PeriodBroken instance
    start = new Date();
    end = new Date();
    period = new PeriodBroken(start, end);
    period.end().setYear(78); // Modifies internals of period!
    System.out.println(period);
  }
}
