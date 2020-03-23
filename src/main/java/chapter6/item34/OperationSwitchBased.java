package chapter6.item34;

// Enum type that switches on its own value - questionable
public enum OperationSwitchBased {
  PLUS,
  MINUS,
  TIMES,
  DIVIDE;

  // Do the arithmetic operation represented by this constant
  public double apply(double x, double y) {
    switch (this) {
      case PLUS:
        return x + y;
      case MINUS:
        return x - y;
      case TIMES:
        return x * y;
      case DIVIDE:
        return x / y;
    }
    throw new AssertionError("Unknown operation: " + this);
  }
}
