package chapter6.item34;

public class WeightTable {

  public static void main(String[] args) {
    double earthWeight = Double.parseDouble(args[0]);
    double mass = earthWeight / Planet.EARTH.surfaceGravity();

    for (Planet planet : Planet.values()) {
      System.err.printf("Weight on %s is %f%n", planet, planet.surfaceWeight(mass));
    }
  }
}
