package uk.co.grahamcox.ccg.webapp.user;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import uk.co.grahamcox.ccg.webapp.types.UserType;

/**
 * Controller for working with Users
 */
@Controller
@RequestMapping("/users")
public class UserController {
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
        throw new UnsupportedOperationException("Not implemented yet");
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
        throw new UnsupportedOperationException("Not implemented yet");
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
