package chapter6.item39.annotationwitharrayparameter;

import chapter6.item39.markerannotation.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Program to process marker annotations and annotations with array parameter
public class RunTests {

  public static void main(String[] args) throws ClassNotFoundException {
    int tests = 0;
    int passed = 0;
    Class<?> testClass = Class.forName(Sample3.class.getName());

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
          boolean hasFailed = true;

          Class<? extends Throwable>[] expectedExceptionTypes =
              method.getAnnotation(ExceptionTest.class).value();
          for (Class<? extends Throwable> expectedException : expectedExceptionTypes) {
            if (expectedException.isInstance(exception)) {
              passed++;
              hasFailed = false;
              break;
            }
          }

          if (hasFailed) {
            System.out.printf("Test %s failed: %s %n", method, exception);
          }
        } catch (Exception e) {
          System.out.println("Invalid @Test: " + method);
        }
      }
    }

    System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
  }
}
