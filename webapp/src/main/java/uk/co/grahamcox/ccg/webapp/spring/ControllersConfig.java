package uk.co.grahamcox.ccg.webapp.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import uk.co.grahamcox.ccg.webapp.leaderboard.LeaderboardController;
import uk.co.grahamcox.ccg.webapp.spring.controllers.UsersControllerConfig;

/**
 * Configuration of controllers
 */
@Configuration
@Import({
    UsersControllerConfig.class
})
public class ControllersConfig {
    /**
     * Construct the leaderboard controller
     * @return the leaderboard controller
     */
    @Bean
    public LeaderboardController leaderboardController() {
        return new LeaderboardController();
    }
}
