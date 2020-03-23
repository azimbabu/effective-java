package chapter3.item10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Broken - violates symmetry!
public class CaseInsensitiveString {
  private final String s;

  public CaseInsensitiveString(String s) {
    this.s = Objects.requireNonNull(s);
  }

  public static void main(String[] args) {
    CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
    String s = "polish";

    List<CaseInsensitiveString> list = new ArrayList<>();
    list.add(cis);

    System.out.println(list.contains(s));
  }

  //    // Fixed equals method
  //    @Override
  //    public boolean equals(Object o) {
  //        return o instanceof CaseInsensitiveString && ((CaseInsensitiveString)
  // o).s.equalsIgnoreCase(s);
  //    }

  // Broken - violates symmetry!
  @Override
  public boolean equals(Object o) {
    if (o instanceof CaseInsensitiveString) {
      return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
    }

    if (o instanceof String) {
      return s.equalsIgnoreCase((String) o); // One-way interoperability!
    }

    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(s);
  }
}
