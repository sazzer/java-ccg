package uk.co.grahamcox.ccg.users;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Optional;
import uk.co.grahamcox.ccg.VersionedId;

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
        Optional<User> result;

        if (userId.getId().equals("123456")) {
            User user = new User();
            user.setId(new VersionedId<>(userId, 5));
            user.setCreated(OffsetDateTime.of(2015, 7, 27, 11, 43, 0, 0, ZoneOffset.UTC).toInstant());
            user.setModified(OffsetDateTime.of(2015, 7, 27, 12, 43, 0, 0, ZoneOffset.UTC).toInstant());
            user.setName("Graham Cox");
            user.setEmail("graham@grahamcox.co.uk");
            user.setEnabled(true);
            result = Optional.of(user);
        } else {
            result = Optional.empty();
        }
        return result;
    }
}
