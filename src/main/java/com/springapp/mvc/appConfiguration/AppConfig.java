package com.springapp.mvc.appConfiguration;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.*;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.*;

@Configuration
@EnableWebMvc
@ComponentScan({"com.springapp.mvc", "org.springframework.web.client"})
public class AppConfig extends WebMvcConfigurerAdapter {

    @Bean RestTemplate restTemplate() { RestTemplate restTemplate = new RestTemplate();
    MappingJacksonHttpMessageConverter converter = new MappingJacksonHttpMessageConverter();
    converter.setObjectMapper(new ObjectMapper()); restTemplate.getMessageConverters().add(converter);
    return restTemplate; }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/WEB-INF/resources/");
    }
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setExposeContextBeansAsAttributes(true);
        return viewResolver;
    }
}
