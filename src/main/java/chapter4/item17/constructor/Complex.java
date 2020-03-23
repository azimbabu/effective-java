package chapter4.item17.constructor;

// Immutable complex number class
public final class Complex {
  public static final Complex ZERO = new Complex(0, 0);
  public static final Complex ONE = new Complex(1, 0);
  public static final Complex I = new Complex(0, 1);

  private final double real;
  private final double imaginary;

  public Complex(double real, double imaginary) {
    this.real = real;
    this.imaginary = imaginary;
  }

  public double getReal() {
    return real;
  }

  public double getImaginary() {
    return imaginary;
  }

  public Complex plus(Complex complex) {
    return new Complex(real + complex.real, imaginary + complex.imaginary);
  }

  public Complex minus(Complex complex) {
    return new Complex(real - complex.real, imaginary - complex.imaginary);
  }

  public Complex times(Complex complex) {
    return new Complex(
        real * complex.real - imaginary * complex.imaginary,
        real * complex.imaginary + imaginary * complex.real);
  }

  public Complex dividedBy(Complex complex) {
    double denominator = complex.real * complex.real + complex.imaginary * complex.imaginary;
    return new Complex(
        (real * complex.real + imaginary * complex.imaginary) / denominator,
        (imaginary * complex.real - real * complex.imaginary) / denominator);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (!(o instanceof Complex)) {
      return false;
    }

    Complex complex = (Complex) o;
    return Double.compare(real, complex.real) == 0
        && Double.compare(imaginary, complex.imaginary) == 0;
  }

  @Override
  public int hashCode() {
    return 31 * Double.hashCode(real) + Double.hashCode(imaginary);
  }

  @Override
  public String toString() {
    return "(" + real + " + " + imaginary + "i)";
  }
}
