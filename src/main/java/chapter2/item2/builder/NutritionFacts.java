package chapter2.item2.builder;

public class NutritionFacts {
  private final int servingSize; // (mL)            required
  private final int servings; // (per container) required
  private final int calories; // (per serving)   optional
  private final int fat; // (g/serving)     optional
  private final int sodium; // (mg/serving)    optional
  private final int carbohydrate; // (g/serving)     optional

  public NutritionFacts(Builder builder) {
    servingSize = builder.servingSize;
    servings = builder.servings;
    calories = builder.calories;
    fat = builder.fat;
    sodium = builder.sodium;
    carbohydrate = builder.carbohydrate;
  }

  public static void main(String[] args) {
    NutritionFacts cocaCola = new Builder(240, 8).calories(100).sodium(35).carbohydrate(27).build();
    System.out.println(cocaCola);
  }

  @Override
  public String toString() {
    return "NutritionFacts{"
        + "servingSize="
        + servingSize
        + ", servings="
        + servings
        + ", calories="
        + calories
        + ", fat="
        + fat
        + ", sodium="
        + sodium
        + ", carbohydrate="
        + carbohydrate
        + '}';
  }

  public static class Builder {
    // Required parameters
    private final int servingSize;
    private final int servings;

    // Optional parameters - initialized to default values
    private int calories = 0;
    private int fat = 0;
    private int sodium = 0;
    private int carbohydrate = 0;

    public Builder(int servingSize, int servings) {
      this.servingSize = servingSize;
      this.servings = servings;
    }

    public Builder calories(int calories) {
      this.calories = calories;
      return this;
    }

    public Builder fat(int fat) {
      this.fat = fat;
      return this;
    }

    public Builder sodium(int sodium) {
      this.sodium = sodium;
      return this;
    }

    public Builder carbohydrate(int carbohydrate) {
      this.carbohydrate = carbohydrate;
      return this;
    }

    public NutritionFacts build() {
      return new NutritionFacts(this);
    }
  }
}
