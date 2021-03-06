package chapter12.item88.mutablefixed;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

public class Period implements Serializable {
  private static final long serialVersionUID = 4035031134364188941L;

  private Date start;
  private Date end;

  // Repaired constructor - makes defensive copies of parameters
  public Period(Date start, Date end) {
    this.start = new Date(start.getTime());
    this.end = new Date(end.getTime());

    if (this.start.compareTo(this.end) > 0) {
      throw new IllegalArgumentException(this.start + " after " + this.end);
    }
  }

  // Repaired accessors - make defensive copies of internal fields
  public Date start() {
    return new Date(start.getTime());
  }

  public Date end() {
    return new Date(end.getTime());
  }

  @Override
  public String toString() {
    return start + "-" + end;
  }

  // readObject method with defensive copying and validity checking
  private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
    stream.defaultReadObject();

    // Defensively copy our mutable components
    start = new Date(start.getTime());
    end = new Date(end.getTime());

    // Check that our invariants are satisfied
    if (start.compareTo(end) > 0) {
      throw new InvalidObjectException(start + " after " + end);
    }
  }
}
