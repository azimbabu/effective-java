package chapter8.item54;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShopCollection {
    private final List<Cheese> cheeseInStock = new ArrayList<>();

    /**
     * Returns null to indicate an empty collection. Don't do this!
     * @return a list containing all of the cheeses in the shop,
     * or null if no cheeses are available for purchase.
     */
    public List<Cheese> getCheesesWrong() {
        return cheeseInStock.isEmpty() ? null : new ArrayList<>(cheeseInStock);
    }

    //The right way to return a possibly empty collection
    public List<Cheese> getCheeses() {
        return new ArrayList<>(cheeseInStock);
    }

    // Optimization - avoids allocating empty collections
    public List<Cheese> getCheesesOptimized() {
        return cheeseInStock.isEmpty() ? Collections.emptyList() : new ArrayList<>(cheeseInStock);
    }

  public static void main(String[] args) {
        ShopCollection shop = new ShopCollection();
        List<Cheese> cheeses = shop.getCheesesWrong();
        if (cheeses != null && cheeses.contains(Cheese.STILTON)) {
            System.out.println("Jolly good, just the thing.");
        }

      cheeses = shop.getCheeses();
      if (cheeses.contains(Cheese.STILTON)) {
          System.out.println("Jolly good, just the thing.");
      }

      cheeses = shop.getCheesesOptimized();
      if (cheeses.contains(Cheese.STILTON)) {
          System.out.println("Jolly good, just the thing.");
      }
  }
}
