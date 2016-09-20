package ru.hbsolutions.partyplanner.config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = {"ru.hbsolutions.partyplanner.dao"})
@Import({
        JpaConfig.class,
        DataSourceConfig.class
})
public class ModelConfig {
}
