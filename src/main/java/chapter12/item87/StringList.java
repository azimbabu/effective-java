package chapter12.item87;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// StringList with a reasonable custom serialized form
public class StringList {
  private transient int size = 0;
  private transient Entry head = null;

  // Appends the specified string to the list
  public final void add(String s) {}

  /**
   * Serialize this @{@code StringList} instance
   *
   * @serialData The size of the list (the number of strings * it contains) is emitted ({@code
   *     int}), followed by all of * its elements (each a {@code String}), in the proper * sequence.
   * @param stream
   * @throws IOException
   */
  private void writeObject(ObjectOutputStream stream) throws IOException {
    stream.defaultWriteObject();
    stream.writeInt(size);

    // Write out all elements in the proper order.
    for (Entry entry = head; entry != null; entry = entry.next) {
      stream.writeObject(entry.data);
    }
  }

  private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
    stream.defaultReadObject();
    int numElements = stream.readInt();

    // Read in all elements and insert them in list
    for (int i = 0; i < numElements; i++) {
      add((String) stream.readObject());
    }
  }

  // No longer Serializable!
  private static class Entry {
    String data;
    Entry next;
    Entry previous;
  }
}
