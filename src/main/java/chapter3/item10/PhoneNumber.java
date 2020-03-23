package chapter3.item10;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumber {
  private final short areaCode, prefix, lineNum;

  public PhoneNumber(int areaCode, int prefix, int lineNum) {
    this.areaCode = rangeCheck(areaCode, 999, "area code");
    this.prefix = rangeCheck(prefix, 999, "prefix");
    this.lineNum = rangeCheck(lineNum, 9999, "line num");
  }

  public static void main(String[] args) {
    Map<PhoneNumber, String> map = new HashMap<>();
    map.put(new PhoneNumber(707, 867, 5309), "Jenny");
    System.out.println(map.get(new PhoneNumber(707, 867, 5309)));
  }

  private short rangeCheck(int value, int max, String arg) {
    if (value < 0 || value > max) {
      throw new IllegalArgumentException(arg + ":" + value);
    }
    return (short) value;
  }

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
}
