package com.jcloud.design.pattern.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author mwl
 * @date 2019/5/23 13:42
 */
@Component
public class SpringBeanTool implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringBeanTool.applicationContext = applicationContext;
    }

    public  static Object getBean(Class cls){
       return applicationContext.getBean(cls);
    }
}
