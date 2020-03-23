package chapter6.item35;

// Abuse of ordinal to derive an associated value
public enum EnsembleBad {
  SOLO,
  DUET,
  TRIO,
  QUARTET,
  QUINTET,
  SEXTET,
  SEPTET,
  OCTET,
  NONET,
  DECTET;

  public int numberOfMusicians() {
    return ordinal() + 1;
  }
}
