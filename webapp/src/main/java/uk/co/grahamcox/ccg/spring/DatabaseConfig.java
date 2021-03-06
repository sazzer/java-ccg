package uk.co.grahamcox.ccg.spring;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;

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
     * @throws SQLException if an error occurs connecting to the database to ingest the schema
     * @throws LiquibaseException if an error occurs ingesting the schema
     */
    @Bean(name = "dataSource")
    @Profile({"dev", "test"})
    public DataSource inMemoryDataSource() throws SQLException, LiquibaseException {
        EmbeddedDatabase dataSource = new EmbeddedDatabaseBuilder()
            .build();

        Database database = DatabaseFactory.getInstance()
            .findCorrectDatabaseImplementation(new JdbcConnection(dataSource.getConnection()));
        Liquibase liquibase = new Liquibase("uk/co/grahamcox/ccg/database/changelog-master.xml",
            new ClassLoaderResourceAccessor(),
            database);
        liquibase.updateTestingRollback(null);

        LOG.info("Created in-memory database: {}", dataSource);
        return dataSource;
    }

    /**
     * Build a JDBC Template to use
     * @param dataSource The data source to build the JDBC Template for
     * @return the JDBC Template to use
     */
    @Bean(name = "jdbcTemplate")
    @Autowired
    public JdbcTemplate jdbcTemplate(final DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.batchUpdate("INSERT INTO USERS(id, version, created, modified, name, email, enabled) VALUES " +
            "(?, ?, ?, ?, ?, ?, ?)",
            Arrays.<Object[]>asList(
            new Object[]{1, 1, new Date(), new Date(), "Graham Cox", "graham@grahamcox.co.uk", true}
        ));

        return jdbcTemplate;
    }
}
