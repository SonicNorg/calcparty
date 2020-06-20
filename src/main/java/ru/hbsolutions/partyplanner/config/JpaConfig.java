package ru.hbsolutions.partyplanner.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
//@PropertySource("classpath:data.properties")
class JpaConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        AbstractJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//        AbstractJpaVendorAdapter adapter = new EclipseLinkJpaVendorAdapter();
        adapter.setDatabase(Database.H2);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource);
        factory.setJpaVendorAdapter(adapter);
        factory.setPackagesToScan("ru.hbsolutions.partyplanner.entity");
        //factory.setPersistenceUnitName("rmcpUnit");

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.connection.charSet", "UTF-8");

        properties.put("hibernate.hbm2ddl.auto", "create");
        properties.put("hibernate.hbm2ddl.charset_name", "UTF-8");
        properties.put("hibernate.hbm2ddl.import_files", "db/sql/data.sql");
        properties.put("hibernate.show_sql", "true");

        properties.put("hibernate.format_sql", true);

//        properties.put("hibernate.cache.use_second_level_cache", true);
//        properties.put("hibernate.cache.use_query_cache", true);
//        properties.put("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
//        properties.put("net.sf.ehcache.configurationResourceName", ".../ehcache.xml");J

//        properties.put("eclipselink.weaving", "static");
//        properties.put("eclipselink.id-validation", "NULL");
//        properties.put("eclipselink.logging.level.sql", "FINE");
//        properties.put("eclipselink.logging.parameters", "true");

        factory.setJpaPropertyMap(properties);
        return factory;
    }
}
