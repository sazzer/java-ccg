package uk.co.grahamcox.ccg.users.dao.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import uk.co.grahamcox.ccg.VersionedId;
import uk.co.grahamcox.ccg.users.User;
import uk.co.grahamcox.ccg.users.UserId;
import uk.co.grahamcox.ccg.users.dao.UserDao;

import java.util.List;
import java.util.Optional;

/**
 * JDBC Implementation of the User DAO
 */
public class JdbcUserDao implements UserDao {
    /** The JDBC Template to use */
    private final JdbcTemplate jdbcTemplate;

    /**
     * Construct the DAO
     * @param jdbcTemplate the JDBC Template to use
     */
    public JdbcUserDao(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Look up the user with the given ID
     * @param userId the ID of the user
     * @return the user
     */
    @Override
    public Optional<User> getById(final UserId userId) {
        List<User> results =
            jdbcTemplate.query("SELECT id, version, created, modified, name, email, enabled FROM users WHERE id = ?",
            new Object[]{userId.getId()},
            (rs, rowNum) -> {
                String id = rs.getString("id");
                Integer version = rs.getInt("version");

                User user = new User();
                user.setId(new VersionedId<>(userId, version));
                user.setCreated(rs.getTimestamp("created").toInstant());
                user.setModified(rs.getTimestamp("modified").toInstant());
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setEnabled(rs.getBoolean("enabled"));

                return user;
            });

        return results.stream()
            .findFirst();
    }
}
