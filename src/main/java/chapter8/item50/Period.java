package chapter8.item50;

import java.util.Date;

public class Period {
  private final Date start;
  private final Date end;

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
}
