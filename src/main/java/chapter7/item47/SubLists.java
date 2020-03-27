package chapter7.item47;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Two ways to generate a stream of all the sublists of a list
public class SubLists {

  // Returns a stream of all the sublists of its input list
  public static <E> Stream<List<E>> of(List<E> list) {
    return Stream.concat(
        Stream.of(Collections.emptyList()), prefixes(list).flatMap(SubLists::suffixes));
  }

  private static <E> Stream<List<E>> prefixes(List<E> list) {
    return IntStream.rangeClosed(1, list.size()).mapToObj(end -> list.subList(0, end));
  }

  private static <E> Stream<List<E>> suffixes(List<E> list) {
    return IntStream.range(0, list.size()).mapToObj(start -> list.subList(start, list.size()));
  }

  public static <E> Stream<List<E>> of2(List<E> list) {
    return IntStream.range(0, list.size())
        .mapToObj(
            start ->
                IntStream.rangeClosed(start + (int) Math.signum(start), list.size())
                    .mapToObj(end -> list.subList(start, end)))
        .flatMap(x -> x);
  }

  public static void main(String[] args) {
    List<Character> list = Arrays.asList('A', 'B', 'C');
    System.out.println("Sublist1");
    SubLists.of(list).forEach(System.out::println);
    System.out.println("Sublist2");
    SubLists.of2(list).forEach(System.out::println);
  }
}
