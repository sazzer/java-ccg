package uk.co.grahamcox.ccg.webapp.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uk.co.grahamcox.ccg.webapp.leaderboard.LeaderboardController;
import uk.co.grahamcox.ccg.webapp.user.UserController;

/**
 * Configuration of controllers
 */
@Configuration
public class ControllersConfig {
    /**
     * Construct the leaderboard controller
     * @return the leaderboard controller
     */
    @Bean
    public LeaderboardController leaderboardController() {
        return new LeaderboardController();
    }
    /**
     * Construct the users controller
     * @return the users controller
     */
    @Bean
    public UserController userController() {
        return new UserController();
    }
}
