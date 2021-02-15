package chapter2.item8;

// Well-behaved client of resource with cleaner safety-net
public class Adult {

  public static void main(String[] args) {
    try (Room room = new Room(7)) {
      System.out.println("Goodbye");
    }
  }
}
