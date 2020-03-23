package chapter6.item39.repeatableannotation;

import java.util.ArrayList;
import java.util.List;

// Program containing repeatable annotations
public class Sample4 {

    @ExceptionTest(ArithmeticException.class)
    public static void m1() {   // Test should pass
        int i=0;
        i /= i;
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m2() {   // Should fail (wrong exception)
        int[] a = new int[0];
        int i = a[1];
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m3() {   // Should fail (no exception)
    }

    // Code containing a repeated annotation
    @ExceptionTest(IndexOutOfBoundsException.class)
    @ExceptionTest(NullPointerException.class)
    public static void doublyBad() {
        List<String> list = new ArrayList<>();

        // The spec permits this method to throw either
        // IndexOutOfBoundsException or NullPointerException
        list.addAll(5, null);
    }
}
