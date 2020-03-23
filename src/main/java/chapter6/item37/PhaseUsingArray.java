package chapter6.item37;

// Using ordinal() to index array of arrays - DON'T DO THIS!
public enum PhaseUsingArray {
  SOLID,
  LIQUID,
  GAS;

  // Simple demo program - prints a sloppy table
  public static void main(String[] args) {
    for (PhaseUsingArray source : PhaseUsingArray.values()) {
      for (PhaseUsingArray destination : PhaseUsingArray.values()) {
        Transition transition = Transition.from(source, destination);
        if (transition != null) {
          System.out.printf("%s to %s : %s %n", source, destination, transition);
        }
      }
    }
  }

  public enum Transition {
    MELT,
    FREEZE,
    BOIL,
    CONDENSE,
    SUBLIME,
    DEPOSIT;

    // Rows indexed by from-ordinal, cols by to-ordinal
    private static final Transition[][] TRANSITIONS = {
      {null, Transition.MELT, Transition.SUBLIME},
      {Transition.FREEZE, null, Transition.BOIL},
      {Transition.DEPOSIT, Transition.CONDENSE, null}
    };

    // Returns the phase transition from one phase to another
    public static Transition from(PhaseUsingArray from, PhaseUsingArray to) {
      return TRANSITIONS[from.ordinal()][to.ordinal()];
    }
  }
}
