package chapter4.item23.hierarchy;

// Class hierarchy replacement for a tagged class
public class Circle extends Figure {

  final double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  @Override
  double area() {
    return Math.PI * (radius * radius);
  }
}
