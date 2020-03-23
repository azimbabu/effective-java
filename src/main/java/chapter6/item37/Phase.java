package chapter6.item37;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

// Using a nested EnumMap to associate data with enum pairs
public enum Phase {
  SOLID,
  LIQUID,
  GAS,
  PLASMA;

  // Simple demo program - prints a sloppy table
  public static void main(String[] args) {
    for (Phase source : values()) {
      for (Phase destination : values()) {
        Transition transition = Transition.from(source, destination);
        if (transition != null) {
          System.out.printf("%s to %s : %s %n", source, destination, transition);
        }
      }
    }
  }

  public enum Transition {
    MELT(SOLID, LIQUID),
    FREEZE(LIQUID, SOLID),
    BOIL(LIQUID, GAS),
    CONDENSE(GAS, LIQUID),
    SUBLIME(SOLID, GAS),
    DEPOSIT(GAS, SOLID),
    IONIZE(GAS, PLASMA),
    DEIONIZE(PLASMA, GAS);

    // Initialize the phase transition map
    private static final Map<Phase, Map<Phase, Transition>> PHASE_TRANSITIONS =
        Stream.of(values())
            .collect(
                groupingBy(
                    transition -> transition.from,
                    () -> new EnumMap<>(Phase.class),
                    Collectors.toMap(
                        transition -> transition.to,
                        transition -> transition,
                        (transition1, transition2) -> transition1,
                        () -> new EnumMap<>(Phase.class))));
    private final Phase from;
    private final Phase to;

    Transition(Phase from, Phase to) {
      this.from = from;
      this.to = to;
    }

    // Returns the phase transition from one phase to another
    public static Transition from(Phase from, Phase to) {
      return PHASE_TRANSITIONS.get(from).get(to);
    }
  }
}
