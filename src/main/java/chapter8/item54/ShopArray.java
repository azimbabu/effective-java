package chapter8.item54;

import java.util.ArrayList;
import java.util.List;

public class ShopArray {
  // Optimization - avoids allocating empty arrays
  private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];
  private final List<Cheese> cheeseInStock = new ArrayList<>();

  public static void main(String[] args) {
    ShopArray shop = new ShopArray();
    Cheese[] cheeses = shop.getCheeses();
    for (Cheese cheese : cheeses) {
      System.out.println(cheese);
    }

    cheeses = shop.getCheesesOptimized();
    for (Cheese cheese : cheeses) {
      System.out.println(cheese);
    }

    shop.addCheese(Cheese.GOUDA);
    shop.addCheese(Cheese.PROVOLONE);

    cheeses = shop.getCheeses();
    for (Cheese cheese : cheeses) {
      System.out.println(cheese);
    }

    cheeses = shop.getCheesesOptimized();
    for (Cheese cheese : cheeses) {
      System.out.println(cheese);
    }
  }

  public void addCheese(Cheese cheese) {
    cheeseInStock.add(cheese);
  }

  // The right way to return a possibly empty array
  public Cheese[] getCheeses() {
    return cheeseInStock.toArray(new Cheese[0]);
  }

  public Cheese[] getCheesesOptimized() {
    return cheeseInStock.toArray(EMPTY_CHEESE_ARRAY);
  }
}
