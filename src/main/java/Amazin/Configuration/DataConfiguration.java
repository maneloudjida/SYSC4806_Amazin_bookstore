/**
 * Trying to initialize the DataSource to connect it to the database
package Amazin.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataConfiguration {
    @Bean(name="dbUser")
    @ConfigurationProperties
    public DataSource createUserDatabase(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "jdbcUser")
    @Autowired
    public JdbcTemplate createJdbcTemplate_UserService(@Qualifier("dbUser") DataSource userDB) {
        return new JdbcTemplate(userDB);
    }
} */
