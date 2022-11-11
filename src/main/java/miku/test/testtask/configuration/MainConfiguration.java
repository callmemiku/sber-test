package miku.test.testtask.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class MainConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {

        DataSource dataSource = DataSourceBuilder.create()
                .url(env.getProperty("spring.datasource.url"))
                .username(env.getProperty("spring.datasource.username"))
                .password(env.getProperty("spring.datasource.password"))
                .driverClassName(env.getProperty("spring.datasource.driver-class-name"))
                .build();
        String maxPoolSize = env.getProperty("spring.datasource.hikari.maximum-pool-size");
        assert maxPoolSize != null;
        ((HikariDataSource) dataSource)
                .setMaximumPoolSize(Integer.parseInt(maxPoolSize));

        return dataSource;
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
