package chapter11.item79.fixedopencall;

import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test3 {
    public static void main(String[] args) {
        ObservableSet<Integer> observableSet = new ObservableSet<>(new HashSet<>());
        observableSet.addObserver(new SetObserver<>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer element) {
                System.out.println(element);
                if (element == 23) {
                    ExecutorService executor = Executors.newSingleThreadExecutor();

                    try {
                        executor.submit(() -> set.removeObserver(this)).get();
                    } catch (ExecutionException | InterruptedException ex) {
                        throw new AssertionError(ex);
                    } finally{
                        executor.shutdown();
                    }
                }
            }
        });
        for (int i=0; i < 100; i++) {
            observableSet.add(i);
        }
    }
}
