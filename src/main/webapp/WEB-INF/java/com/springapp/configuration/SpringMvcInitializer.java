package com.springapp.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMvcInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
//        return new Class[]{AppConfig.class};
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{Initializer.class,AppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"} ;
    }
}
