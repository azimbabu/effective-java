package chapter3.item14;

import java.util.Objects;

// Single-field Comparable with object reference field
public class CaseInsensitiveString implements Comparable<CaseInsensitiveString> {
  private final String s;

  public CaseInsensitiveString(String s) {
    this.s = Objects.requireNonNull(s);
  }

  @Override
  public boolean equals(Object o) {
    return o instanceof CaseInsensitiveString && ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
  }

  @Override
  public int hashCode() {
    return Objects.hash(s);
  }

  @Override
  public int compareTo(CaseInsensitiveString cis) {
    return String.CASE_INSENSITIVE_ORDER.compare(s, cis.s);
  }
}
