package chapter12.item90;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

// Immutable class that uses defensive copying
public class Period implements Serializable {
  private final Date start;
  private final Date end;

  /**
   * @param start the beginning of the period
   * @param end the end of the period; must not precede start
   * @throws IllegalArgumentException if start is after end
   * @throws NullPointerException if start or end is null
   */
  public Period(Date start, Date end) {
    this.start = start;
    this.end = end;

    if (this.start.compareTo(this.end) > 0) {
      throw new IllegalArgumentException(start + " after " + end);
    }
  }

  public Date start() {
    return new Date(start.getTime());
  }

  public Date end() {
    return new Date(end.getTime());
  }

  // writeReplace method for the serialization proxy pattern
  private Object writeReplace() {
    return new SerializationProxy(this);
  }

  // readObject method for the serialization proxy pattern
  private void readObject(ObjectInputStream stream) throws InvalidObjectException {
    throw new InvalidObjectException("Proxy required");
  }

  private static class SerializationProxy implements Serializable {
    private static final long serialVersionUID = 3951678694040738644L;

    private final Date start;
    private final Date end;

    SerializationProxy(Period period) {
      this.start = period.start;
      this.end = period.end;
    }

    // readResolve method for Period.SerializationProxy
    private Object readResolve() {
      return new Period(start, end); // Uses public constructor
    }
  }
}
