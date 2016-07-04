package su.vistar.testtask_netcracker.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.orm.jpa.AbstractEntityManagerFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author dantonov
 */

@Configuration
@ComponentScan(basePackages = {"su.vistar.testtask_netcracker.config", "su.vistar.testtask_netcracker.service"}, 
               excludeFilters = {
                   @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
               })
@EnableTransactionManagement
public class AppConfig {

    
    @Autowired
    @Bean
    public JpaTransactionManager transactionManager(AbstractEntityManagerFactoryBean entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        
        transactionManager.setEntityManagerFactory(entityManagerFactory.getObject());
        
        return transactionManager;
    }
    
    
    
}
