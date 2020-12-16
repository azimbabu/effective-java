package chapter11.item79.broken;

import java.util.HashSet;

// More complex test of ObservableSet : ConcurrentModificationException
public class Test2 {
    public static void main(String[] args) {
        ObservableSet<Integer> observableSet = new ObservableSet<>(new HashSet<>());
        observableSet.addObserver(new SetObserver<>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer element) {
                System.out.println(element);
                if (element == 23) {
                    set.removeObserver(this);
                }
            }
        });
        for (int i=0; i < 100; i++) {
            observableSet.add(i);
        }
    }
}
