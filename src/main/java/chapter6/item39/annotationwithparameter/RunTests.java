package chapter6.item39.annotationwithparameter;

import chapter6.item39.markerannotation.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTests {

  public static void main(String[] args) throws ClassNotFoundException {
    int tests = 0;
    int passed = 0;
    Class<?> testClass = Class.forName(Sample2.class.getName());

    for (Method method : testClass.getDeclaredMethods()) {
      if (method.isAnnotationPresent(Test.class)) {
        tests++;
        try {
          method.invoke(null);
          passed++;
        } catch (InvocationTargetException wrappedException) {
          Throwable exception = wrappedException.getCause();
          System.out.println(method + " failed: " + exception);
        } catch (Exception e) {
          System.out.println("Invalid @Test: " + method);
        }
      }

      if (method.isAnnotationPresent(ExceptionTest.class)) {
        tests++;

        try {
          method.invoke(null);
        } catch (InvocationTargetException wrappedException) {
          Throwable exception = wrappedException.getCause();
          Class<? extends Throwable> value = method.getAnnotation(ExceptionTest.class).value();
          if (value.isInstance(exception)) {
            passed++;
          } else {
            System.out.printf(
                "Test %s failed: expected %s, got %s%n", method, value.getName(), exception);
          }
        } catch (Exception ex) {
          System.out.println("Invalid @Test: " + method);
        }
      }
    }

    System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
  }
}
