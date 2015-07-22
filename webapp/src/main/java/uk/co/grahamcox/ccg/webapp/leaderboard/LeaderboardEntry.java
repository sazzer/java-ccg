package uk.co.grahamcox.ccg.webapp.leaderboard;

/**
 * Single entry on a Leaderboard
 */
public class LeaderboardEntry {
    /** The user */
    private final UserLink user;

    /** The score */
    private final int score;

    /**
     * Construct the leaderboard entry
     * @param user the user
     * @param score the score
     */
    public LeaderboardEntry(final UserLink user, final int score) {
        this.user = user;
        this.score = score;
    }

    /**
     * Get {@link #user}
     *
     * @return {@link #user}
     */
    public UserLink getUser() {
        return user;
    }

    /**
     * Get {@link #score}
     *
     * @return {@link #score}
     */
    public int getScore() {
        return score;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LeaderboardEntry{");
        sb.append("user=").append(user);
        sb.append(", score=").append(score);
        sb.append('}');
        return sb.toString();
    }
}
