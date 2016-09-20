package ru.hbsolutions.partyplanner.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
//@EnableAsync
@ComponentScan({
        "ru.hbsolutions.partyplanner.service"
})
public class ServiceConfig {
}
