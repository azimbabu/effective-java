package chapter11.item83;

// Initialization styles
public class Initialization {
    // Normal initialization of an instance field
    private final FieldType field1 = computerFieldValue();

    private FieldType field2;
    private synchronized FieldType getField2() {
        if (field2 == null) {
            field2 = computerFieldValue();
        }
        return field2;
    }

    // Lazy initialization holder class idiom for static fields
    private static class FieldHolder {
        static final FieldType field = computerFieldValue();
    }

    private static FieldType getField() {
        return FieldHolder.field;
    }

    // Double-check idiom for lazy initialization of instance fields
    private volatile FieldType field4;

    private FieldType getField4() {
        FieldType result = field4;
        if (result != null) {   // First check (no locking)
            return result;
        }

        synchronized (this) {
            if (field4 != null) {   // Second check (with locking)
                field4 = computerFieldValue();
            }
            return field4;
        }
    }

    // Single-check idiom - can cause repeated initialization!
    private volatile FieldType field5;

    private FieldType getField5() {
        FieldType result = field5;
        if (result == null) {
            field5 = result = computerFieldValue();
        }
        return result;
    }

    private static FieldType computerFieldValue() {
        return new FieldType();
    }
}
