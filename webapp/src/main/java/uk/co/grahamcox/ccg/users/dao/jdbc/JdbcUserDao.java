package uk.co.grahamcox.ccg.users.dao.jdbc;

import uk.co.grahamcox.ccg.users.User;
import uk.co.grahamcox.ccg.users.UserId;
import uk.co.grahamcox.ccg.users.dao.UserDao;

import java.util.Optional;

/**
 * JDBC Implementation of the User DAO
 */
public class JdbcUserDao implements UserDao {
    @Override
    public Optional<User> getById(final UserId userId) {
        return Optional.empty();
    }
}
