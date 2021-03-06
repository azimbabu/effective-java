package chapter11.item79.fixedopencall;

import chapter11.item79.ForwardingSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class ObservableSet<E> extends ForwardingSet<E> {
  private final List<SetObserver<E>> observers = new ArrayList<>();

  public ObservableSet(Set<E> set) {
    super(set);
  }

  public void addObserver(SetObserver<E> observer) {
    synchronized (observers) {
      observers.add(observer);
    }
  }

  public boolean removeObserver(SetObserver<E> observer) {
    synchronized (observers) {
      return observers.remove(observer);
    }
  }

  // Alien method moved outside of synchronized block - open calls
  private void notifyElementAdded(E element) {
    List<SetObserver<E>> snapshot = null;

    synchronized (observers) {
      snapshot = new ArrayList<>(observers);
    }

    for (SetObserver<E> observer : snapshot) {
      observer.added(this, element);
    }
  }

  @Override
  public boolean add(E element) {
    boolean added = super.add(element);
    if (added) {
      notifyElementAdded(element);
    }
    return added;
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    boolean result = false;
    for (E element : c) {
      result |= add(element); // Calls notifyElementAdded
    }
    return result;
  }
}
