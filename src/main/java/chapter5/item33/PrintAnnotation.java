package chapter5.item33;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

// Use of asSubclass to safely cast to a bounded type token
public class PrintAnnotation {

  static Annotation getAnnotation(AnnotatedElement element, String annotationTypeName) {
    Class<?> annotationType = null; // Unbounded type token
    try {
      annotationType = Class.forName(annotationTypeName);
    } catch (ClassNotFoundException ex) {
      throw new IllegalArgumentException(ex);
    }
    return element.getAnnotation(annotationType.asSubclass(Annotation.class));
  }

  public static void main(String[] args) throws ClassNotFoundException {
    if (args.length != 2) {
      System.err.println("Usage: java PrintAnnotation <class> <annotation>");
      System.exit(1);
    }

    String className = args[0];
    String annotationTypeName = args[1];
    Class<?> klass = Class.forName(className);
    System.out.println(getAnnotation(klass, annotationTypeName));
  }
}
