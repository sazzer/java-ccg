package uk.co.grahamcox.ccg;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Holder for a Versioned ID
 * @param <T> The type of ID to work with
 */
public class VersionedId<T extends Id<?>> {
    /** The ID */
    private final T id;

    /** The version number */
    private final int version;

    /**
     * Construct the Versioned ID
     * @param id the ID
     * @param version the Version Number
     */
    public VersionedId(final T id, final int version) {
        this.id = id;
        this.version = version;
    }

    /**
     * Get {@link #id}
     *
     * @return {@link #id}
     */
    public T getId() {
        return id;
    }

    /**
     * Get {@link #version}
     *
     * @return {@link #version}
     */
    public int getVersion() {
        return version;
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
