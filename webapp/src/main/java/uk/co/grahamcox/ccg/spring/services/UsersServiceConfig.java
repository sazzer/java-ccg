package uk.co.grahamcox.ccg.spring.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.co.grahamcox.ccg.users.UserLoader;

/**
 * Spring Config for the Users Services
 */
@Configuration
public class UsersServiceConfig {
    /**
     * Construct the User Loader service
     * @return the User Loader
     */
    @Bean(name = "userLoader")
    public UserLoader userLoader() {
        return new UserLoader();
    }
}
