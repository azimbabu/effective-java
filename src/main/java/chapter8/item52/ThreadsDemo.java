package chapter8.item52;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsDemo {
  public static void main(String[] args) {
    new Thread(System.out::println).start();

    ExecutorService executorService = Executors.newCachedThreadPool();
    //      executorService.submit(System.out::println);
  }
}
