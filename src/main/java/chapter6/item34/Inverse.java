package chapter6.item34;

// Switch on an enum to simulate a missing method
public class Inverse {

  public static Operation inverse(Operation operation) {
    switch (operation) {
      case PLUS:
        return Operation.MINUS;
      case MINUS:
        return Operation.PLUS;
      case TIMES:
        return Operation.DIVIDE;
      case DIVIDE:
        return Operation.TIMES;
      default:
        throw new AssertionError("Unknown operation: " + operation);
    }
  }

  public static void main(String[] args) {
    double x = Double.parseDouble(args[0]);
    double y = Double.parseDouble(args[1]);
    for (Operation operation : Operation.values()) {
      Operation invOperation = inverse(operation);
      System.out.printf(
          "%f %s %f %s %f = %f%n",
          x, operation, y, invOperation, y, invOperation.apply(operation.apply(x, y), y));
    }
  }
}
