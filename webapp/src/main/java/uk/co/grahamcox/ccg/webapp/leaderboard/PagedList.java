package uk.co.grahamcox.ccg.webapp.leaderboard;

import java.util.List;

/**
 * Representation of a single page in an overall list of results
 * @param <T> the type of result
 */
public class PagedList<T> {
    /** The actual list of entries */
    private final List<T> entries;

    /** The total number of entries */
    private final int totalEntries;

    /**
     * Construct the paged list
     * @param entries the entries
     * @param totalEntries the total number of entries
     */
    public PagedList(final List<T> entries, final int totalEntries) {
        this.entries = entries;
        this.totalEntries = totalEntries;
    }

    /**
     * Get {@link #entries}
     *
     * @return {@link #entries}
     */
    public List<T> getEntries() {
        return entries;
    }

    /**
     * Get {@link #totalEntries}
     *
     * @return {@link #totalEntries}
     */
    public int getTotalEntries() {
        return totalEntries;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PagedList{");
        sb.append("entries=").append(entries);
        sb.append(", totalEntries=").append(totalEntries);
        sb.append('}');
        return sb.toString();
    }
}
