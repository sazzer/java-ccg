package uk.co.grahamcox.ccg.users;

import uk.co.grahamcox.ccg.users.dao.UserDao;

import java.util.Optional;

/**
 * Mechanisms to support loading users
 */
public class UserLoader {
    /** The User DAO to use */
    private final UserDao userDao;

    /**
     * Construct the User Loader
     * @param userDao the User DAO to use
     */
    public UserLoader(final UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * Load the user with the given ID
     * @param userId the User ID
     * @return the user
     */
    public Optional<User> loadUserById(final UserId userId) {
        Optional<User> result = userDao.getById(userId);

        return result;
    }
}
