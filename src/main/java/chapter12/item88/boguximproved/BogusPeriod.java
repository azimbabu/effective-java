package chapter12.item88.boguximproved;

import java.io.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class BogusPeriod {

  // Byte stream couldn't have come from a real Period instance!
  private static final byte[] serializedForm = {
    (byte) 0xac,
    (byte) 0xed,
    0x00,
    0x05,
    0x73,
    0x72,
    0x00,
    0x25,
    0x63,
    0x68,
    0x61,
    0x70,
    0x74,
    0x65,
    0x72,
    0x31,
    0x32,
    0x2e,
    0x69,
    0x74,
    0x65,
    0x6d,
    0x38,
    0x38,
    0x2e,
    0x62,
    0x6f,
    0x67,
    0x75,
    0x78,
    0x69,
    0x6d,
    0x70,
    0x72,
    0x6f,
    0x76,
    0x65,
    0x64,
    0x2e,
    0x50,
    0x65,
    0x72,
    0x69,
    0x6f,
    0x64,
    0x0d,
    0x71,
    0x07,
    (byte) 0x9d,
    0x1b,
    (byte) 0xe3,
    (byte) 0xb3,
    (byte) 0xc1,
    0x02,
    0x00,
    0x02,
    0x4c,
    0x00,
    0x03,
    0x65,
    0x6e,
    0x64,
    0x74,
    0x00,
    0x10,
    0x4c,
    0x6a,
    0x61,
    0x76,
    0x61,
    0x2f,
    0x75,
    0x74,
    0x69,
    0x6c,
    0x2f,
    0x44,
    0x61,
    0x74,
    0x65,
    0x3b,
    0x4c,
    0x00,
    0x05,
    0x73,
    0x74,
    0x61,
    0x72,
    0x74,
    0x71,
    0x00,
    0x7e,
    0x00,
    0x01,
    0x78,
    0x70,
    0x73,
    0x72,
    0x00,
    0x0e,
    0x6a,
    0x61,
    0x76,
    0x61,
    0x2e,
    0x75,
    0x74,
    0x69,
    0x6c,
    0x2e,
    0x44,
    0x61,
    0x74,
    0x65,
    0x68,
    0x6a,
    (byte) 0x81,
    0x01,
    0x4b,
    0x59,
    0x74,
    0x19,
    0x03,
    0x00,
    0x00,
    0x78,
    0x70,
    0x77,
    0x08,
    0x00,
    0x00,
    0x00,
    0x66,
    (byte) 0xdf,
    0x6e,
    0x1e,
    0x00,
    0x78,
    0x73,
    0x71,
    0x00,
    0x7e,
    0x00,
    0x03,
    0x77,
    0x08,
    0x00,
    0x00,
    0x00,
    (byte) 0xd5,
    0x17,
    0x69,
    0x22,
    0x00,
    0x78,
  };

  public static void main(String[] args) {
    // printByteArray();
    Period period = (Period) deserialize(serializedForm);
    System.out.println(period);
  }

  private static void printByteArray() {
    Period period =
        new Period(
            Date.from(
                LocalDateTime.of(1999, 01, 01, 12, 00, 00)
                    .atZone(ZoneId.systemDefault())
                    .toInstant()),
            Date.from(
                LocalDateTime.of(1984, 01, 01, 12, 00, 00)
                    .atZone(ZoneId.systemDefault())
                    .toInstant()));

    byte[] serialized = serialize(period);
    StringBuilder result = new StringBuilder();
    result.append("{");
    for (byte b : serialized) {
      result.append(String.format("0x%02x", b));
      result.append(", ");
    }
    result.append("}");
    System.out.println(result);
  }

  // Returns the object with the specified serialized form
  static Object deserialize(byte[] serializedForm) {
    try {
      return new ObjectInputStream(new ByteArrayInputStream(serializedForm)).readObject();
    } catch (IOException | ClassNotFoundException ex) {
      throw new IllegalArgumentException(ex);
    }
  }

  static byte[] serialize(Period period) {
    ObjectOutputStream stream = null;
    try {
      ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
      stream = new ObjectOutputStream(arrayOutputStream);
      stream.writeObject(period);
      stream.flush();
      return arrayOutputStream.toByteArray();
    } catch (IOException ex) {
      ex.printStackTrace();
    } finally {
      try {
        stream.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    return null;
  }
}
