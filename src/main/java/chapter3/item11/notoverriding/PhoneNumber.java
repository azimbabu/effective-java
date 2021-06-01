package chapter3.item11.notoverriding;

import java.util.HashMap;
import java.util.Map;

// Shows the need for overriding hashcode when you override equals
public class PhoneNumber {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max) {
            throw new IllegalArgumentException(arg + ":" + val);
        }
        return (short) val;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof PhoneNumber)) {
            return false;
        }

        PhoneNumber phoneNumber = (PhoneNumber) obj;
        return phoneNumber.lineNum == lineNum && phoneNumber.prefix == prefix && phoneNumber.areaCode == areaCode;
    }

  public static void main(String[] args) {
      Map<PhoneNumber, String> map = new HashMap<>();
      map.put(new PhoneNumber(707, 867, 5309), "Jenny");
      System.out.println(map.get(new PhoneNumber(707, 867, 5309)));
  }
}
