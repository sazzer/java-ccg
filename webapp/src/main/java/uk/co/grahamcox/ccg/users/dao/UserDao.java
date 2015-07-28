package uk.co.grahamcox.ccg.users.dao;

import uk.co.grahamcox.ccg.users.User;
import uk.co.grahamcox.ccg.users.UserId;

import java.util.Optional;

/**
 * DAO for accessing User records
 */
public interface UserDao {
    /**
     * Get the User from the database that has the given ID
     * @param userId the ID of the user
     * @return the user record, or empty if it wasn't found
     */
    Optional<User> getById(UserId userId);
}
