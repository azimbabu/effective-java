package chapter2.item3.staticfactory;

public class Elvis {

  private static final Elvis INSTANCE = new Elvis();

  private Elvis() {}

  public static Elvis getInstance() {
    return INSTANCE;
  }

  // This code would normally appear outside the class!
  public static void main(String[] args) {
    Elvis elvis = Elvis.getInstance();
    elvis.leaveTheBuilding();
  }

  public void leaveTheBuilding() {
    System.out.println("Whoa baby, I'm outta here!");
  }
}
