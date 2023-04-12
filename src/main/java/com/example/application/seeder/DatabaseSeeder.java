package com.example.application.seeder;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void insertData() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS person");

        jdbcTemplate.execute("CREATE TABLE person(" +
                "id INT NOT NULL AUTO_INCREMENT," +
                "first_name varchar(255), " +
                "last_name varchar(255)," +
                "PRIMARY KEY (id))");

        jdbcTemplate.execute("INSERT INTO person(first_name,last_name) VALUES('Fabio', 'Geisser')");
        jdbcTemplate.execute("INSERT INTO person(first_name,last_name) VALUES('Emanuel', 'Lerch')");
        jdbcTemplate.execute("INSERT INTO person(first_name,last_name) VALUES('Rut', 'Böckel')");
    }
}
