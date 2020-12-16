package chapter8.item56;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Documentation comment examples
public class DocExamples<E> {

  // Method comment
  /**
   * Returns the element at the specified position in this list.
   *
   * <p>This method is <i>not</i> guranteed to run in constant time. In some implementations it may
   * run proportional to the element position.
   *
   * @param index index of element to return; must be non-negative and less than the size of this
   *     list
   * @return the element at the specified position in this list
   * @throws IndexOutOfBoundsException if the index is out of range ({@code index < 0 || index >=
   *     this.size()})
   */
  E get(int index) {
    return null;
  }

  // Use of @implSpec to describe self-use patterns & other visible implementation details.
  /**
   * Returns true if this collection is empty.
   *
   * @implSpec This implementation returns {@code this.size() == 0}.
   * @return true if this collection is empty
   */
  public boolean isEmpty() {
    return false;
  }

  // Use of the @literal tag to include HTML and javadoc metacharacters in javadoc comments.
  /** A geometric series converges if {@literal |r| < 1}. */
  public void fragment() {}

  // Controlling summary description when there is a period in the first "sentence" of doc comment.

  /** This method compiles with the {@index IEEE 754} standard. */
  public void fragment2() {}

  // Generating a javadoc index entry in Java 9 and later releases.

  /** A suspect, such as Colonel Mustard or {@literal Mrs. Peacock}. */
  public enum FixedSuspect {
    MISS_SCARLETT,
    PROFESSOR_PLUM,
    MRS_PEACOCK,
    MR_GREEN,
    COLONEL_MUSTARD,
    MRS_WHITE
  }

  /** An instrument section of a symphony orchestra. */
  public enum OrchestraSection {
    /** Woodwinds, such as flute, clarinet, and oboe. */
    WOODWIND,

    /** Brass instruments, such as french horn and trumpet. */
    BRASS,

    /** Percussion instruments, such as timpani and cymbals. */
    PERCUSSION,

    /** Stringed instruments, such as violin and cello. */
    STRING;
  }

  // Documenting enum constants

  /**
   * An object that maps keys to values. A map cannot contain duplicate keys; each key can map to at
   * most one value.
   *
   * @param <K> the type of keys maintained by this map
   * @param <V> the type of mapped values
   */
  public interface Map<K, V> {}

  // Documenting an annotation type
  /**
   * Indicates that the annotated method is a test method that must throw the designated exception
   * to pass.
   */
  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.METHOD)
  public @interface ExceptionTest {

    /**
     * The exception that the annotated test method must throw in order to pass. (The test is
     * permitted to throw any subtype of the type described by this class object.)
     */
    Class<? extends Throwable> value();
  }
}
