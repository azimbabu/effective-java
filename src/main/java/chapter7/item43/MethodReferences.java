package chapter7.item43;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferences {
  public static void main(String[] args) {
    // Static method reference
    List<Integer> nums1 =
        Arrays.asList("1", "2", "3", "4", "5").stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    System.out.println(nums1);

    // Lambda equivalent of static method reference
    List<Integer> nums2 =
        Arrays.asList("1", "2", "3", "4", "5").stream()
            .map(s -> Integer.parseInt(s))
            .collect(Collectors.toList());
    System.out.println(nums2);

    // Bound instance method reference
    List<Boolean> isAfterChecks1 =
        Arrays.asList(Instant.now().minusSeconds(3600), Instant.now().plusSeconds(3600)).stream()
            .map(Instant.now()::isAfter)
            .collect(Collectors.toList());
    System.out.println(isAfterChecks1);

    // Lambda equivalent of bound instance method reference
    Instant now = Instant.now();
    List<Boolean> isAfterChecks2 =
        Arrays.asList(Instant.now().minusSeconds(3600), Instant.now().plusSeconds(3600)).stream()
            .map(otherInstant -> now.isAfter(otherInstant))
            .collect(Collectors.toList());
    System.out.println(isAfterChecks2);

    // Unbound instance method reference
    List<String> names1 =
        Arrays.asList("James", "Morgan", "Paul").stream()
            .map(String::toLowerCase)
            .collect(Collectors.toList());
    System.out.println(names1);

    // Lambda equivalent of unbound instance method reference
    List<String> names2 =
        Arrays.asList("James", "Morgan", "Paul").stream()
            .map(s -> s.toLowerCase())
            .collect(Collectors.toList());
    System.out.println(names2);
  }
}
