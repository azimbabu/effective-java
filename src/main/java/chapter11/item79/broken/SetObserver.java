package chapter11.item79.broken;

import chapter11.item79.broken.ObservableSet;

// Set obeserver callback interface
@FunctionalInterface
public interface SetObserver<E> {
    // Invoked when an element is added to the observable set
    void added(ObservableSet<E> set, E element);
}
