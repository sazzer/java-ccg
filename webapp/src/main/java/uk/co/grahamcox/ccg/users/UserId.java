package uk.co.grahamcox.ccg.users;

import uk.co.grahamcox.ccg.Id;

/**
 * Representation of the ID of a User
 */
public class UserId extends Id<String> {
    /**
     * Construct the User ID
     * @param id the User ID
     */
    public UserId(final String id) {
        super(id);
    }
}
