package ru.hbsolutions.partyplanner;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import ru.hbsolutions.partyplanner.config.ModelConfig;
import ru.hbsolutions.partyplanner.config.RestConfig;
import ru.hbsolutions.partyplanner.config.ServiceConfig;
import ru.hbsolutions.partyplanner.config.WebConfig;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {
                ServiceConfig.class,
                ModelConfig.class,
                RestConfig.class,
                WebConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

}
