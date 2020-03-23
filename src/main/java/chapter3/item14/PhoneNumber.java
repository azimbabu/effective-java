package chapter3.item14;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

// Making PhoneNumber comparable
public class PhoneNumber implements Comparable<PhoneNumber> {
  private static final Comparator<PhoneNumber> COMPARATOR =
      Comparator.comparingInt((PhoneNumber phoneNumber) -> phoneNumber.areaCode)
          .thenComparing(phoneNumber -> phoneNumber.prefix)
          .thenComparing(phoneNumber -> phoneNumber.lineNum);
  private final short areaCode, prefix, lineNum;

  public PhoneNumber(int areaCode, int prefix, int lineNum) {
    this.areaCode = rangeCheck(areaCode, 999, "area code");
    this.prefix = rangeCheck(prefix, 999, "prefix");
    this.lineNum = rangeCheck(lineNum, 9999, "line num");
  }

  public static void main(String[] args) {
    NavigableSet<PhoneNumber> set = new TreeSet<>();
    for (int i = 0; i < 10; i++) {
      set.add(randomPhoneNumber());
    }
    System.out.println(set);
  }

  private static PhoneNumber randomPhoneNumber() {
    Random random = ThreadLocalRandom.current();
    return new PhoneNumber(random.nextInt(1000), random.nextInt(1000), random.nextInt(10000));
  }

  private short rangeCheck(int value, int max, String arg) {
    if (value < 0 || value > max) {
      throw new IllegalArgumentException(arg + ":" + value);
    }
    return (short) value;
  }

  //    @Override
  //    public int compareTo(PhoneNumber phoneNumber) {
  //        int result = Short.compare(areaCode, phoneNumber.areaCode);
  //        if (result == 0) {
  //            result = Short.compare(prefix, phoneNumber.prefix);
  //            if (result == 0) {
  //                result = Short.compare(lineNum, phoneNumber.lineNum);
  //            }
  //        }
  //        return result;
  //    }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof PhoneNumber)) {
      return false;
    }

    PhoneNumber phoneNumber = (PhoneNumber) o;
    return phoneNumber.lineNum == lineNum
        && phoneNumber.prefix == prefix
        && phoneNumber.areaCode == areaCode;
  }

  @Override
  public int hashCode() {
    int result = Short.hashCode(areaCode);
    result = 31 * result + Short.hashCode(prefix);
    result = 31 * result + Short.hashCode(lineNum);
    return result;
  }

  /**
   * Returns the string representation of this phone number. The string consists of twelve
   * characters whose format is "XXX-YYY-ZZZZ", where XXX is the area code, YYY is the prefix, and
   * ZZZZ is the line number. Each of the capital letters represents a single decimal digit.
   *
   * <p>If any of the three parts of this phone number is too small to fill up its field, the field
   * is padded with leading zeros. For example, if the value of the line number is 123, the last
   * four characters of the string representation will be "0123".
   */
  @Override
  public String toString() {
    return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
  }

  @Override
  public int compareTo(PhoneNumber phoneNumber) {
    return COMPARATOR.compare(this, phoneNumber);
  }
}
