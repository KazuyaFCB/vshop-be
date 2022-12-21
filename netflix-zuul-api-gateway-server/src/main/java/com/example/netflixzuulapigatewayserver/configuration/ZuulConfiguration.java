package com.example.netflixzuulapigatewayserver.configuration;

import org.springframework.beans.BeansException;
import org.springframework.cloud.netflix.zuul.web.ZuulHandlerMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/*
This class is used to resolve issue:
java.lang.NoSuchMethodError: 'java.lang.String org.springframework.boot.web.servlet.error.ErrorController.getErrorPath()'
	at org.springframework.cloud.netflix.zuul.web.ZuulHandlerMapping.lookupHandler(ZuulHandlerMapping.java:87) ~[spring-cloud-netflix-zuul-2.2.10.RELEASE.jar:2.2.10.RELEASE]
Refer: https://github.com/spring-cloud/spring-cloud-netflix/issues/4008 (Comment of andrey-6478)
* */

@Configuration
public class ZuulConfiguration implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (applicationContext.containsBean("zuulHandlerMapping")) {
            applicationContext.getBean(ZuulHandlerMapping.class).setErrorController(null);
        }
    }
}