package thjug.rr;

import java.util.Optional;

/**
 * Project option class<br>
 * This help I use optional pattern on Java lower than 8.
 *
 * @author Peerapat Asoktummarungsri
 */
public final class Option<T> {

    private final T t;
    private static final Option<?> EMPTY = new Option<>();

    private Option() {
        t = null;
    }

    private Option(final T value) {
        this.t = value;
    }

    /**
     * Return Optional of T
     *
     * @return Option&lt;T>
     */
    public static <T> Option<T> of(final T value) {
        return new Option<>(value);
    }

    /**
     * Return Empty Optional
     *
     * @return Option&lt;T>
     */
    public static <T> Option<T> empty() {
        return (Option<T>) EMPTY;
    }

    /**
     * Get value in Option
     *
     * @return value
     */
    public T get() {
        return t;
    }

    /**
     * Return true if value is not null.
     *
     * @return boolean
     */
    public boolean isPresent() {
        return t != null;
    }

    /**
     * Return true if value is null.
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return t == null;
    }

    /**
     * Transfer to standard Java Optional.<br>
     * Support on Java 8 upper.
     *
     * @return java.util.Optional&lt;T>
     */
    public Optional<T> toOptional() {
        return (t != null) ? Optional.of(t) : (Optional<T>) Optional.empty();
    }

}
