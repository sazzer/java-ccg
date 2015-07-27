package uk.co.grahamcox.ccg.webapp.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import uk.co.grahamcox.ccg.users.UserLoader;
import uk.co.grahamcox.ccg.webapp.user.UserController;
import uk.co.grahamcox.ccg.webapp.user.UserTranslator;

/**
 * Controller Config for the Users Controller
 */
public class UsersControllerConfig {
    /** The user loader service */
    @Autowired
    private UserLoader userLoader;

    /**
     * Construct the users controller
     * @return the users controller
     */
    @Bean
    public UserController userController() {
        UserTranslator userTranslator = new UserTranslator();
        return new UserController(userLoader, userTranslator);
    }

}
