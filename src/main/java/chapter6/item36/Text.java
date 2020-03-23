package chapter6.item36;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

// EnumSet - a modern replacement for bit fields
public class Text {

  // Sample use
  public static void main(String[] args) {
    Text text = new Text();
    text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    text.applyStyles(EnumSet.of(Style.UNDERLINE, Style.STRIKETHROUGH));
  }

  // Any Set could be passed in, but EnumSet is clearly best
  public void applyStyles(Set<Style> styles) {
    System.out.printf("Applying styles %s to text%n", Objects.requireNonNull(styles));
  }

  public enum Style {
    BOLD,
    ITALIC,
    UNDERLINE,
    STRIKETHROUGH
  }
}
