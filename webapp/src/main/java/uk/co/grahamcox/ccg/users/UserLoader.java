package uk.co.grahamcox.ccg.users;

import java.util.Optional;

/**
 * Mechanisms to support loading users
 */
public class UserLoader {
    /**
     * Load the user with the given ID
     * @param userId the User ID
     * @return the user
     */
    public Optional<User> loadUserById(final UserId userId) {
        return Optional.empty();
    }
}
