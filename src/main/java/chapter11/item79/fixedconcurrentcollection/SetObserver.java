package chapter11.item79.fixedconcurrentcollection;

// Set obeserver callback interface
@FunctionalInterface
public interface SetObserver<E> {
    // Invoked when an element is added to the observable set
    void added(ObservableSet<E> set, E element);
}