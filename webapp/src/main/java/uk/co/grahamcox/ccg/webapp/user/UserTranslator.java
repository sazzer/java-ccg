package uk.co.grahamcox.ccg.webapp.user;

import java.util.Date;
import uk.co.grahamcox.ccg.users.User;
import uk.co.grahamcox.ccg.webapp.types.UserType;

/**
 * Translator between the internal and HTTP version of a User
 */
public class UserTranslator {
    /**
     * Translate the user into the HTTP Version
     * @param user the user to translate
     * @return the HTTP version
     */
    public UserType translate(final User user) {
        UserType result = new UserType();
        user.getId().ifPresent(id -> {
            result.setId(id.getId().getId());
            result.setVersion(id.getVersion());
        });
        user.getCreated()
            .map(Date::from)
            .ifPresent(result::setCreated);
        user.getModified()
            .map(Date::from)
            .ifPresent(result::setModified);
        result.setName(user.getName());
        result.setEmail(user.getEmail());
        result.setEnabled(user.isEnabled());

        return result;
    }
}
