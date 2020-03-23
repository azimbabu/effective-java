package chapter6.item37;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

// Simplistic class representing a plant
public class Plant {

  private final String name;
  private final LifeCycle lifeCycle;

  public Plant(String name, LifeCycle lifeCycle) {
    this.name = name;
    this.lifeCycle = lifeCycle;
  }

  public static void main(String[] args) {
    Plant[] garden = {
      new Plant("Basil", LifeCycle.ANNUAL),
      new Plant("Carroway", LifeCycle.BIENNIAL),
      new Plant("Dill", LifeCycle.ANNUAL),
      new Plant("Lavendar", LifeCycle.PERENNIAL),
      new Plant("Parsley", LifeCycle.BIENNIAL),
      new Plant("Rosemary", LifeCycle.PERENNIAL)
    };

    // Using ordinal() to index into an array - DON'T DO THIS!
    Set<Plant>[] plantsByLifeCycleArray = new Set[LifeCycle.values().length];
    for (int i = 0; i < plantsByLifeCycleArray.length; i++) {
      plantsByLifeCycleArray[i] = new HashSet<>();
    }

    for (Plant plant : garden) {
      plantsByLifeCycleArray[plant.lifeCycle.ordinal()].add(plant);
    }

    // Print the results
    for (int i = 0; i < plantsByLifeCycleArray.length; i++) {
      System.out.printf("%s: %s%n", Plant.LifeCycle.values()[i], plantsByLifeCycleArray[i]);
    }

    // Using an EnumMap to associate data with an enum
    Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);

    for (Plant plant : garden) {
      if (!plantsByLifeCycle.containsKey(plant.lifeCycle)) {
        plantsByLifeCycle.put(plant.lifeCycle, new HashSet<>());
      }
      plantsByLifeCycle.get(plant.lifeCycle).add(plant);
    }

    System.out.println(plantsByLifeCycle);

    // Naive stream-based approach - unlikely to produce an EnumMap!
    System.out.println(Arrays.stream(garden).collect(groupingBy(plant -> plant.lifeCycle)));

    // Using a stream and an EnumMap to associate data with an enum
    System.out.println(
        Arrays.stream(garden)
            .collect(
                groupingBy(
                    plant -> plant.lifeCycle, () -> new EnumMap<>(LifeCycle.class), toSet())));
  }

  @Override
  public String toString() {
    return name;
  }

  enum LifeCycle {
    ANNUAL,
    PERENNIAL,
    BIENNIAL
  }
}
