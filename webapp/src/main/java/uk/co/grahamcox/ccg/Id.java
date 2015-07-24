package uk.co.grahamcox.ccg;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Base class for an ID
 * @param <T> the type of the ID
 */
public abstract class Id<T> {
    /** The ID */
    private final T id;

    /**
     * Construct the ID
     * @param id the ID
     */
    public Id(final T id) {
        this.id = id;
    }

    /**
     * Get {@link #id}
     *
     * @return {@link #id}
     */
    public T getId() {
        return id;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(final Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
