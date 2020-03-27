package chapter7.item47;

import java.util.*;

public class PowerSet {
  // Returns the power set of an input set as custom collection
  public static final <E> Collection<Set<E>> of(Set<E> set) {
    List<E> source = new ArrayList<>(set);
    if (source.size() > 30) {
      throw new IllegalArgumentException("Set is too big: " + set);
    }

    return new AbstractList<>() {
      @Override
      public Set<E> get(int index) {
        Set<E> result = new HashSet<>();
        for (int i = 0; index != 0; i++, index >>= 1) {
          if ((index & 1) == 1) {
            result.add(source.get(i));
          }
        }
        return result;
      }

      @Override
      public int size() {
        return 1 << source.size(); // 2 to the power sourceSize
      }

      @Override
      public boolean contains(Object o) {
        return o instanceof Set && source.containsAll((Set) o);
      }
    };
  }

  public static void main(String[] args) {
    Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3));
    System.out.println(PowerSet.of(set));
  }
}
