package chapter6.item39.markerannotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Program to process marker annotations
public class RunTests {

    public static void main(String[] args) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;

//        Class<?> testClass = Class.forName(args[0]);
        Class<?> testClass = Class.forName("chapter6.item39.markerannotation.Sample");
        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                tests++;

                try {
                    method.invoke(null);
                    passed++;
                } catch (InvocationTargetException wrappedException) {
                    Throwable exception = wrappedException.getCause();
                    System.out.println(method + " failed: " + exception);
                } catch (Exception ex) {
                    System.out.println("Invalid @Test: " + method);
                }
            }
        }

        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }
}
