package chapter11.item78.fixedserialnumber;

import java.util.concurrent.atomic.AtomicLong;

public class SerialNumber {
  // Lock-free synchronization with java.util.concurrent.atomic
  private static AtomicLong nextSerialNumber = new AtomicLong();

  public static long generateSerialNumber() {
    return nextSerialNumber.getAndIncrement();
  }

  public static void main(String[] args) {
    Thread thread1 =
        new Thread(
            () -> {
              for (int i = 0; i < 10; i++) {
                System.out.println(generateSerialNumber());
              }
            });

    Thread thread2 =
        new Thread(
            () -> {
              for (int i = 0; i < 10; i++) {
                System.out.println(generateSerialNumber());
              }
            });

    thread1.start();
    thread2.start();
  }
}
