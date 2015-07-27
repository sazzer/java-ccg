package uk.co.grahamcox.ccg.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;

/**
 * Spring Configuration for connecting to the database
 */
@Configuration
public class DatabaseConfig {
    /** The logger to use */
    private static final Logger LOG = LoggerFactory.getLogger(DatabaseConfig.class);
    /**
     * Construct an in-memory data source if needed
     * @return the data source
     */
    @Bean(name = "dataSource")
    @Profile({"dev", "test"})
    public DataSource inMemoryDataSource() {
        EmbeddedDatabase database = new EmbeddedDatabaseBuilder()
            .build();

        LOG.info("Created in-memory database: {}", database);
        return database;
    }
}
