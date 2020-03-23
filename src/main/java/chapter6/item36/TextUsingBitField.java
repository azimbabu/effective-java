package chapter6.item36;

// Bit field enumeration constants - OBSOLETE
public class TextUsingBitField {

  public static final int STYLE_BOLD = 1 << 0; // 1
  public static final int STYLE_ITALIC = 1 << 1; // 2
  public static final int STYLE_UNDERLINE = 1 << 2; // 4
  public static final int STYLE_STRIKETHROUGH = 1 << 1; // 8

  public static void main(String[] args) {
    TextUsingBitField text = new TextUsingBitField();
    text.applyStyles(STYLE_BOLD | STYLE_ITALIC);
    text.applyStyles(STYLE_UNDERLINE | STYLE_STRIKETHROUGH);
  }

  // Parameter is bitwise OR of zero or more STYLE_ constants-
  public void applyStyles(int styles) {
    System.out.printf("Applying styles %d to text%n", styles);
  }
}
