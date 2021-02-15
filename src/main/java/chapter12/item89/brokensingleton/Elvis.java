package chapter12.item89.brokensingleton;

import java.io.Serializable;
import java.util.Arrays;

// Broken singleton - has nontransient object reference field!
public class Elvis implements Serializable {
  public static final Elvis INSTANCE = new Elvis();
  private static final long serialVersionUID = 4042394513566312310L;
  private String[] favoriteSongs = {"Hound Dog", "Heartbreak Hotel"};

  private Elvis() {}

  public void printFavorites() {
    System.out.println(Arrays.toString(favoriteSongs));
  }

  private Object readResolve() {
    return INSTANCE;
  }
}
