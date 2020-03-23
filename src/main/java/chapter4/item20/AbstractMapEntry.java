package chapter4.item20;

import java.util.Map;
import java.util.Objects;

// Skeletal implementation class
public abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {

  // Entries in a modifiable map must override this method
  @Override
  public V setValue(V value) {
    throw new UnsupportedOperationException();
  }

  // Implements the general contract of Map.Entry.hashCode
  @Override
  public int hashCode() {
    return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
  }

  // Implements the general contract of Map.Entry.equals
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }

    if (!(obj instanceof Map.Entry)) {
      return false;
    }

    Map.Entry<?, ?> entry = (Map.Entry<?, ?>) obj;
    return Objects.equals(entry.getKey(), getKey()) && Objects.equals(entry.getValue(), getValue());
  }

  @Override
  public String toString() {
    return getKey() + "=" + getValue();
  }
}
