package su.vistar.testtask_netcracker.config;

import java.util.Properties;

import javax.annotation.Resource;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;

/**
 *
 * @author dantonov
 */
@Configuration
@EnableJpaRepositories(basePackages = { "su.vistar.testtask_netcracker.repository" })
@PropertySource("classpath:application.properties")
public class DataConfig {

    private static final String PROPERTY_NAME_DB_DEVELOPMENT_DRIVER = "db.development.driver";
    private static final String PROPERTY_NAME_DB_DEVELOPMENT_URL = "db.development.url";
    private static final String PROPERTY_NAME_DB_DEVELOPMENT_USERNAME = "db.development.username";
    private static final String PROPERTY_NAME_DB_DEVELOPMENT_PASSWORD = "db.development.password";

    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES = "entitymanager.packages";
    
    
    @Resource
    private Environment env;
    
    
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DB_DEVELOPMENT_DRIVER));
        dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DB_DEVELOPMENT_URL));
        dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DB_DEVELOPMENT_USERNAME));
        dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DB_DEVELOPMENT_PASSWORD));

        return dataSource;
    }
    
    @Autowired
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        
        entityManager.setDataSource(dataSource);
        entityManager.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManager.setJpaDialect(new HibernateJpaDialect());
        entityManager.setPackagesToScan(env.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES));
        entityManager.setJpaProperties(getHibernateProperties());
        
        return entityManager;
    }
    
    
    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        
        properties.put("hibernate.dialect", env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
        properties.put("hibernate.show_sql", env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
        
        return properties;
    }
    
}
