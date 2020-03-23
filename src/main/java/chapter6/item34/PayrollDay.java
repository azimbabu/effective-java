package chapter6.item34;

// The strategy enum pattern
public enum PayrollDay {
  MONDAY,
  TUESDAY,
  WEDNESDAY,
  THURSDAY,
  FRIDAY,
  SATURDAY(PayType.WEEKEND),
  SUNDAY(PayType.WEEKEND);

  private final PayType payType;

  PayrollDay(PayType payType) {
    this.payType = payType;
  }

  PayrollDay() {
    this(PayType.WEEKDAY); // Default
  }

  public static void main(String[] args) {
    for (PayrollDay day : values()) {
      System.out.printf("%-10s%d%n", day, day.pay(8 * 60, 1));
    }
  }

  int pay(int minutesWorked, int payRate) {
    return payType.pay(minutesWorked, payRate);
  }

  // The strategy enum type
  private enum PayType {
    WEEKDAY {
      @Override
      int overtimePay(int minutesWorked, int payRate) {
        return minutesWorked <= MINS_PER_SHIFT ? 0 : (minutesWorked - MINS_PER_SHIFT) * payRate / 2;
      }
    },

    WEEKEND {
      @Override
      int overtimePay(int minutesWorked, int payRate) {
        return minutesWorked * payRate / 2;
      }
    };

    private static final int MINS_PER_SHIFT = 8 * 60;

    abstract int overtimePay(int minutesWorked, int payRate);

    int pay(int minutesWorked, int payRate) {
      int basePay = minutesWorked * payRate;
      return basePay + overtimePay(minutesWorked, payRate);
    }
  }
}
