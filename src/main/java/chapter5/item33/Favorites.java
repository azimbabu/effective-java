package chapter5.item33;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// Typesafe heterogeneous container pattern - API
public class Favorites {

  private Map<Class<?>, Object> favorites = new HashMap<>();

  // Typesafe heterogeneous container pattern - client
  public static void main(String[] args) {
    Favorites favorites = new Favorites();

    favorites.putFavorite(String.class, "Java");
    favorites.putFavorite(Integer.class, 0xcafebabe);
    favorites.putFavorite(Class.class, Favorites.class);

    String favoriteString = favorites.getFavorite(String.class);
    int favoriteInteger = favorites.getFavorite(Integer.class);
    Class<?> favoriteClass = favorites.getFavorite(Class.class);

    System.out.printf("%s %x %s%n", favoriteString, favoriteInteger, favoriteClass.getName());
  }

  public <T> void putFavorite(Class<T> type, T instance) {
    favorites.put(Objects.requireNonNull(type), type.cast(instance));
  }

  public <T> T getFavorite(Class<T> type) {
    return type.cast(favorites.get(type));
  }
}
