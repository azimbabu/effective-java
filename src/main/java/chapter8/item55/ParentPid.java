package chapter8.item55;

import java.util.Optional;

// Avoiding unnecessary use of Optional's isPresent method
public class ParentPid {
  public static void main(String[] args) {
    ProcessHandle currentProcessHandle = ProcessHandle.current();

    // Inappropriate use of isPresent
    Optional<ProcessHandle> parentProcessHandle = currentProcessHandle.parent();
    System.out.println(
        "Parent PID: "
            + (parentProcessHandle.isPresent()
                ? String.valueOf(parentProcessHandle.get().pid())
                : "N/A"));

    // Equivalent (and superior) code using orElse
    System.out.println(
        "Parent PID: "
            + parentProcessHandle
                .map(processHandle -> String.valueOf(processHandle.pid()))
                .orElse("N/A"));
  }
}
