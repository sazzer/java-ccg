package uk.co.grahamcox.ccg.webapp.spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.List;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Configuration for the Spring WebMVC details
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    /** Base for the API Schema handlers */
    private static final String API_SCHEMA_URL = "/api/schema";

    /** URL for the API Schema RAML file */
    private static final String CCG_RAML_URL = API_SCHEMA_URL + "/ccg.raml";

    /** View for the API Schema RAML file */
    private static final String CCG_RAML_VIEW = "schema.raml";

    /** {@inheritDoc} */
    @Override
    public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /** {@inheritDoc} */
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources/");
        registry.addResourceHandler(API_SCHEMA_URL + "/**/*.json").addResourceLocations("classpath:/schema/");
    }

    /** {@inheritDoc} */
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController(CCG_RAML_URL).setViewName(CCG_RAML_VIEW);
        registry.addRedirectViewController(API_SCHEMA_URL, CCG_RAML_URL);
    }

    /**
     * Set up the JSP Resolver
     * @return the Internal View Resolver for JSP handling
     */
    @Bean
    public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setPrefix("/WEB-INF/jsp/");
        bean.setSuffix(".jsp");
        return bean;
    }

    /**
     * Set up the Message Source to use for generating translated messages
     * @return the message source
     */
    @Bean(name = "messageSource")
    public MessageSource getMessageSource() {
        ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
        resource.setBasename("classpath:uk/co/grahamcox/ccg/messages");
        resource.setDefaultEncoding("UTF-8");
        return resource;
    }

    /**
     * Configure all of the message converters to use. Specifically we have a custom Jackson converter for JSON
     * @param converters The list of converters to work with
     */
    @Override
    public void configureMessageConverters(final List<HttpMessageConverter<?>> converters) {
        // First, add all of the default converters we actually care about
        converters.add(new ByteArrayHttpMessageConverter());
        converters.add(new StringHttpMessageConverter());
        converters.add(new ResourceHttpMessageConverter());
        converters.add(new FormHttpMessageConverter());

        // Then our custom ones
        converters.add(new MappingJackson2HttpMessageConverter(getObjectMapper()));
    }

    /**
     * Construct the Jackson Object Mapper to use
     * @return the Jackson Object Mapper
     */
    @Bean(name = "objectMapper")
    public ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.registerModule(new Jdk8Module());

        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return objectMapper;
    }
}
