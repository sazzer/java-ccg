package uk.co.grahamcox.ccg.webapp.leaderboard;

/**
 * Link to a user in a controller response
 */
public class UserLink {
    /** The ID of the user */
    private final String id;

    /** The name of the user */
    private final String name;

    /**
     * Construct the user link
     * @param id the ID
     * @param name the name
     */
    public UserLink(final String id, final String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Get {@link #id}
     *
     * @return {@link #id}
     */
    public String getId() {
        return id;
    }

    /**
     * Get {@link #name}
     *
     * @return {@link #name}
     */
    public String getName() {
        return name;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserLink{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
