package ru.hbsolutions.partyplanner.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
class DataSourceConfig {

    @Primary
    @Bean
    public DataSource dataSource() {

        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder
                .setType(EmbeddedDatabaseType.H2)
                //.addScript("db/sql/data.sql")
                .build();
    }

/*
    @Bean
    public DataSource dataSource() {

        // no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder
                .setType(EmbeddedDatabaseType.HSQL) //.H2 or .DERBY
                .addScript("db/sql/create-db.sql")
                .addScript("db/sql/insert-data.sql")
                .build();
        return db;
    }
*/
}
