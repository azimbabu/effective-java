package chapter12.item89.fixedsingleton;

import java.util.Arrays;

// Enum singleton - the preferred approach
public enum Elvis {
    INSTANCE;

    private String[] favoriteSongs = {"Hound Dog", "Heartbreak Hotel"};

    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }
}
