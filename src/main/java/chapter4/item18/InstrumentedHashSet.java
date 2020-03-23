package chapter4.item18;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

// Broken - Inappropriate use of inheritance!
public class InstrumentedHashSet<E> extends HashSet<E> {
  private int addCount = 0;

  public InstrumentedHashSet() {}

  public InstrumentedHashSet(int initialCapacity, float loadFactor) {
    super(initialCapacity, loadFactor);
  }

  public static void main(String[] args) {
    InstrumentedHashSet<String> set = new InstrumentedHashSet<>();
    set.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
    System.out.println(set.getAddCount());
  }

  @Override
  public boolean add(E e) {
    addCount++;
    return super.add(e);
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    addCount += c.size();
    return super.addAll(c);
  }

  public int getAddCount() {
    return addCount;
  }
}
