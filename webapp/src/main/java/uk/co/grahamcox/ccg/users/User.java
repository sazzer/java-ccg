package uk.co.grahamcox.ccg.users;

import java.time.Instant;
import java.util.Optional;
import uk.co.grahamcox.ccg.VersionedId;

/**
 * Representation of a User
 */
public class User {
    /** The ID of the User */
    private Optional<VersionedId<UserId>> id;

    /** When the User was created */
    private Optional<Instant> created;

    /** When the User was last modified */
    private Optional<Instant> modified;

    /** The name of the user */
    private String name;

    /** The email address of the user */
    private String email;

    /** Whether the user is enabled */
    private boolean enabled;

    /**
     * Get {@link #id}
     *
     * @return {@link #id}
     */
    public Optional<VersionedId<UserId>> getId() {
        return id;
    }

    /**
     * Set {@link #id}
     *
     * @param id New value for {@link #id}
     */
    public void setId(final Optional<VersionedId<UserId>> id) {
        this.id = id;
    }

    /**
     * Set {@link #id}
     *
     * @param id New value for {@link #id}
     */
    public void setId(final VersionedId<UserId> id) {
        setId(Optional.of(id));
    }

    /**
     * Set {@link #id}
     */
    public void resetId() {
        setId(Optional.empty());
    }

    /**
     * Get {@link #created}
     *
     * @return {@link #created}
     */
    public Optional<Instant> getCreated() {
        return created;
    }

    /**
     * Set {@link #created}
     *
     * @param created New value for {@link #created}
     */
    public void setCreated(final Optional<Instant> created) {
        this.created = created;
    }

    /**
     * Set {@link #created}
     *
     * @param created New value for {@link #created}
     */
    public void setCreated(final Instant created) {
        setCreated(Optional.of(created));
    }

    /**
     * Set {@link #created}
     */
    public void resetCreated() {
        setCreated(Optional.empty());
    }

    /**
     * Get {@link #modified}
     *
     * @return {@link #modified}
     */
    public Optional<Instant> getModified() {
        return modified;
    }

    /**
     * Set {@link #modified}
     *
     * @param modified New value for {@link #modified}
     */
    public void setModified(final Optional<Instant> modified) {
        this.modified = modified;
    }

    /**
     * Set {@link #modified}
     *
     * @param modified New value for {@link #modified}
     */
    public void setModified(final Instant modified) {
        setModified(Optional.of(modified));
    }

    /**
     * Set {@link #modified}
     */
    public void resetModified() {
        setModified(Optional.empty());
    }

    /**
     * Get {@link #name}
     *
     * @return {@link #name}
     */
    public String getName() {
        return name;
    }

    /**
     * Set {@link #name}
     *
     * @param name New value for {@link #name}
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Get {@link #email}
     *
     * @return {@link #email}
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set {@link #email}
     *
     * @param email New value for {@link #email}
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * Get {@link #enabled}
     *
     * @return {@link #enabled}
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Set {@link #enabled}
     *
     * @param enabled New value for {@link #enabled}
     */
    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }
}
