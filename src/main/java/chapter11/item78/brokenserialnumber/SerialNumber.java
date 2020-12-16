package chapter11.item78.brokenserialnumber;

public class SerialNumber {
    // Broken - requires synchronization!
    private static volatile int nextSerialNumber = 0;

    public static int generateSerialNumber() {
        return nextSerialNumber++;
    }

  public static void main(String[] args) {
    Thread thread1 = new Thread(() -> {
        for (int i=0; i < 10; i++) {
            System.out.println(generateSerialNumber());
        }
    });

      Thread thread2 = new Thread(() -> {
          for (int i=0; i < 10; i++) {
              System.out.println(generateSerialNumber());
          }
      });

      thread1.start();
      thread2.start();
  }
}
