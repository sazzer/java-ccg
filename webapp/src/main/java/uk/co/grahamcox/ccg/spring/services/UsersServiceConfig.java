package uk.co.grahamcox.ccg.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import uk.co.grahamcox.ccg.users.UserLoader;
import uk.co.grahamcox.ccg.users.dao.UserDao;
import uk.co.grahamcox.ccg.users.dao.jdbc.JdbcUserDao;

/**
 * Spring Config for the Users Services
 */
@Configuration
public class UsersServiceConfig {
    /**
     * Construct the User DAO
     * @param jdbcTemplate The JDBC Template to use to talk to the database
     * @return the User DAO
     */
    @Bean(name = "userDao")
    @Autowired
    public UserDao userDao(final JdbcTemplate jdbcTemplate) {
        return new JdbcUserDao(jdbcTemplate);
    }

    /**
     * Construct the User Loader service
     * @param userDao The User DAO to use
     * @return the User Loader
     */
    @Bean(name = "userLoader")
    @Autowired
    public UserLoader userLoader(final UserDao userDao) {
        return new UserLoader(userDao);
    }
}
