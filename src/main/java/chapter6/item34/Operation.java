package chapter6.item34;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Enum type with constant-specific class bodies and data
public enum Operation {
  PLUS("+") {
    @Override
    public double apply(double x, double y) {
      return x + y;
    }
  },

  MINUS("-") {
    @Override
    public double apply(double x, double y) {
      return x - y;
    }
  },

  TIMES("*") {
    @Override
    public double apply(double x, double y) {
      return x * y;
    }
  },

  DIVIDE("/") {
    @Override
    public double apply(double x, double y) {
      return x / y;
    }
  };

  // Implementing a fromString method on an enum type
  private static final Map<String, Operation> stringToEnum =
      Stream.of(values()).collect(Collectors.toMap(Object::toString, operation -> operation));
  private final String symbol;

  Operation(String symbol) {
    this.symbol = symbol;
  }

  public static Optional<Operation> fromString(String symbol) {
    return Optional.ofNullable(stringToEnum.get(symbol));
  }

  public static void main(String[] args) {
    double x = Double.parseDouble(args[0]);
    double y = Double.parseDouble(args[1]);

    for (Operation operation : Operation.values()) {
      System.out.printf("%f %s %f = %f%n", x, operation, y, operation.apply(x, y));
    }
  }

  @Override
  public String toString() {
    return symbol;
  }

  public abstract double apply(double x, double y);
}
