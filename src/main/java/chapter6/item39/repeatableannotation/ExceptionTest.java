package chapter6.item39.repeatableannotation;

import java.lang.annotation.*;

// Repeatable annotation type
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ExceptionTestContainer.class)
public @interface ExceptionTest {
  Class<? extends Throwable> value();
}
