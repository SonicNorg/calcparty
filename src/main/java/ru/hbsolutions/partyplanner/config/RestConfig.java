package ru.hbsolutions.partyplanner.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan({
        "ru.hbsolutions.partyplanner.rest.controller",
})
public class RestConfig {
}
