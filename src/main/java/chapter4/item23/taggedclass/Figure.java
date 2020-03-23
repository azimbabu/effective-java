package chapter4.item23.taggedclass;

// Tagged class - vastly inferior to a class hierarchy!
public class Figure {

  // Tag field - the shape of this figure
  final Shape shape;
  // These fields are used only if shape is RECTANGLE
  double length;
  double width;
  // This field is used only if shape is CIRCLE
  double radius;

  // Constructor for circle
  Figure(double radius) {
    shape = Shape.CIRCLE;
    this.radius = radius;
  }

  // Constructor for rectangle
  Figure(double length, double width) {
    shape = Shape.REACTANGLE;
    this.length = length;
    this.width = width;
  }

  double area() {
    switch (shape) {
      case CIRCLE:
        return Math.PI * (radius * radius);
      case REACTANGLE:
        return length * width;
      default:
        throw new AssertionError(shape);
    }
  }

  enum Shape {
    REACTANGLE,
    CIRCLE
  }
}
