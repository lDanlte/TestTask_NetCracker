package su.vistar.testtask_netcracker.config;


import com.fasterxml.jackson.core.JsonEncoding;

import java.nio.charset.Charset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 *
 * @author dantonov
 */
@Configuration
@ComponentScan(basePackages = { "su.vistar.testtask_netcracker.controller" })
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        Map<String,MediaType> mediaTypes = new HashMap<>();
        
        mediaTypes.put("json",MediaType.APPLICATION_JSON);
        mediaTypes.put("html",MediaType.TEXT_HTML);
        
        configurer.mediaTypes(mediaTypes);
    }

    
    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);
        
        List<ViewResolver> resolvers = new ArrayList<>();

        resolvers.add(jsonViewResolver());
        resolvers.add(internalResourceViewResolver());

        resolver.setViewResolvers(resolvers);
        return resolver;
    }
    
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
        registry.addResourceHandler("/lib/**").addResourceLocations("/resources/lib/");
    }
    
    
    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }
    
    
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        
        viewResolver.setPrefix("/resources/jsp/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setContentType("text/html;charset=UTF-8");
        
        return viewResolver;
    }
    
    @Bean
    public ViewResolver jsonViewResolver() {
        return (String string, Locale locale) -> {
            MappingJackson2JsonView view = new MappingJackson2JsonView();
            
            view.setPrettyPrint(true);
            view.setEncoding(JsonEncoding.UTF8);
            
            return view;
        };
    }
    
    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
