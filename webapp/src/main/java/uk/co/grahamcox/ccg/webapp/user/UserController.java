package uk.co.grahamcox.ccg.webapp.user;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import uk.co.grahamcox.ccg.VersionedId;
import uk.co.grahamcox.ccg.users.User;
import uk.co.grahamcox.ccg.users.UserId;
import uk.co.grahamcox.ccg.users.UserLoader;
import uk.co.grahamcox.ccg.webapp.RecordNotFoundException;
import uk.co.grahamcox.ccg.webapp.RecordVersionMismatchException;
import uk.co.grahamcox.ccg.webapp.types.UserType;

import java.util.Optional;

/**
 * Controller for working with Users
 */
@Controller
@RequestMapping("/api/users")
public class UserController {
    /** The User Loader to use to load User records with */
    private final UserLoader userLoader;

    /** The User Translator to use */
    private final UserTranslator userTranslator;

    /**
     * Construct the User Controller
     * @param userLoader the User Loader
     * @param userTranslator The user translator
     */
    public UserController(final UserLoader userLoader,
        final UserTranslator userTranslator) {
        this.userLoader = userLoader;
        this.userTranslator = userTranslator;
    }

    /**
     * Exception Handler for when the requested record wasn't found
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RecordNotFoundException.class)
    public void recordNotFound() {

    }

    /**
     * Exception Handler for when the requested record wasn't of the correct version
     */
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(RecordVersionMismatchException.class)
    public void recordVersionMismatch() {

    }

    /**
     * Get the user details for the currently authenticated user
     * @return the user details
     */
    @RequestMapping(value = "/me", method = RequestMethod.GET)
    @ResponseBody
    public UserType getMe() {
        // TODO: Fix the hard-coded User ID when Authentication is supported
        return getUser("123456");
    }

    /**
     * Get the user details for the requested user
     * @param userId The ID of the user to request
     * @return the user details
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public UserType getUser(@PathVariable("userId") final String userId) {
        Optional<User> user = userLoader.loadUserById(new UserId(userId));

        return user.map(userTranslator::translate)
            .orElseThrow(RecordNotFoundException::new);
    }

    /**
     * Update the user details for the requested user
     * @param userId The ID of the user to update
     * @param user The new details of the user
     * @return the user details
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    @ResponseBody
    public UserType updateUser(@PathVariable("userId") final String userId,
        @RequestBody final UserType user) {
        User currentUser = userLoader.loadUserById(new UserId(userId))
            .orElseThrow(RecordNotFoundException::new);

        if (user.getVersion() != null) {
            VersionedId<UserId> currentUserId = currentUser.getId().orElseThrow(RecordVersionMismatchException::new);
            if (!user.getVersion().equals(currentUserId.getVersion())) {
                throw new RecordVersionMismatchException();
            }
        }

        return null;
    }

    /**
     * Delete the user details for the requested user
     * @param userId The ID of the user to delete
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("userId") final String userId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Create a new user
     * @param user The new user details
     * @return the user details
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public UserType createUser(@RequestBody final UserType user) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
