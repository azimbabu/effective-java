package chapter5.item31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

public class Stack<E> {

  private static final int DEFAULT_INITIAL_CAPACITY = 16;
  private E[] elements;
  private int size = 0;

  // The elements array will contain only E instances from push(E).
  // This is sufficient to ensure type safety, but the runtime
  // type of the array won't be E[]; it will always be Object[]!
  @SuppressWarnings("unchecked")
  public Stack() {
    elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
  }

  // Little program to exercise our generic Stack
  public static void main(String[] args) {
    Stack<Number> numberStack = new Stack<>();
    Iterable<Integer> integers = Arrays.asList(3, 1, 4, 1, 5, 9);
    numberStack.pushAll(integers);

    Collection<Object> objects = new ArrayList<>();
    numberStack.popAll(objects);
    System.out.println(objects);
  }

  public void push(E e) {
    ensureCapacity();
    elements[size++] = e;
  }

  public E pop() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }

    E result = elements[--size];
    elements[size] = null; // Eliminate obsolete reference
    return result;
  }

  //    // pushAll method without wildcard type - deficient!
  //    public void pushAll(Iterable<E> source) {
  //        for (E e : source) {
  //            push(e);
  //        }
  //    }

  public boolean isEmpty() {
    return size == 0;
  }

  //    // popAll method without wildcard type - deficient!
  //    public void popAll(Collection<E> destination) {
  //        while (!isEmpty()) {
  //            destination.add(pop());
  //        }
  //    }

  // Wildcard type for a parameter that serves as an E producer
  public void pushAll(Iterable<? extends E> source) {
    for (E e : source) {
      push(e);
    }
  }

  // Wildcard type for parameter that serves as an E consumer
  public void popAll(Collection<? super E> destination) {
    while (!isEmpty()) {
      destination.add(pop());
    }
  }

  private void ensureCapacity() {
    if (size == elements.length) {
      elements = Arrays.copyOf(elements, 2 * size + 1);
    }
  }
}
