package chapter6.item38;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

// Emulated extensible enum
public enum ExtendedOperation implements Operation {
    EXP("^") {
        @Override
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    },

    REMAINDER("%") {
        @Override
        public double apply(double x, double y) {
            return x % y;
        }
    };

    private final String symbol;

    ExtendedOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    // Using a collection instance to represent a collection of extended enums
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        test1(ExtendedOperation.class, x ,y);
        test2(Arrays.asList(ExtendedOperation.values()), x ,y);
    }

    private static <T extends Enum<T> & Operation> void test1(Class<T> operationEnumType, double x, double y) {
        for (Operation operation : operationEnumType.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n", x, operation, y, operation.apply(x, y));
        }
    }

    private static void test2(Collection<? extends Operation> operations, double x, double y) {
        operations.stream().forEach(operation -> System.out.printf("%f %s %f = %f%n", x, operation, y, operation.apply(x, y)));
    }
}
