package chapter9.item65;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;

// Reflective instantiation with interface access
public class ReflectiveInstantiation {

  public static void main(String[] args) {
    // Translate the class name into a Class object
    Class<? extends Set<String>> setClass = null;
    try {
      setClass = (Class<? extends Set<String>>) Class.forName(args[0]); // Unchecked cast!
    } catch (ClassNotFoundException e) {
      fatalError("Class not found.");
    }

    // Get the constructor
    Constructor<? extends Set<String>> constructor = null;
    try {
      constructor = setClass.getDeclaredConstructor();
    } catch (NoSuchMethodException e) {
      fatalError("No parameterless constructor");
    }

    // Instantiate the set
    Set<String> set = null;
    try {
      set = constructor.newInstance();
    } catch (InstantiationException e) {
      fatalError("Class not instantiable.");
    } catch (IllegalAccessException e) {
      fatalError("Constructor not accessible");
    } catch (InvocationTargetException e) {
      fatalError("Constructor threw " + e.getCause());
    } catch (ClassCastException ex) {
      fatalError("Class doesn't implement Set");
    }

    // Exercise the set
    set.addAll(Arrays.asList(args).subList(1, args.length));
    System.out.println(set);
  }

  private static void fatalError(String msg) {
    System.err.println(msg);
    System.exit(1);
  }
}
