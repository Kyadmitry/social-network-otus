package com.example.socialnetwork.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
public class SqlQueriesConfig {

    @Bean
    public Properties userSqlQueries() {
        Properties properties = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("sql/user.sql")) {
            if (inputStream == null) {
                throw new IllegalStateException("User SQL queries file not found.");
            }
            properties.load(inputStream);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load user SQL queries.", e);
        }
        return properties;
    }
}
