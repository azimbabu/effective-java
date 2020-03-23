package chapter4.item23.hierarchy;

// Class hierarchy replacement for a tagged class
public class Rectangle extends Figure {

  final double length;

  final double width;

  public Rectangle(double length, double width) {
    this.length = length;
    this.width = width;
  }

  @Override
  double area() {
    return length * width;
  }
}
