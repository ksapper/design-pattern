package com.jcloud.design.pattern.behavior.strategy;

import com.jcloud.design.pattern.behavior.strategy.annotate.HanderType;
import lombok.extern.slf4j.Slf4j;
import org.cent.scanner.core.scanner.ClassScanner;
import org.cent.scanner.core.scanner.impl.DefaultClassScanner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mwl
 * @date 2019/5/23 13:57
 */
@Component
@Slf4j
public class HanderContextProcessor implements BeanFactoryPostProcessor {

    private ClassScanner classScanner = new DefaultClassScanner();

    private final List<String> scanpkg = Arrays.asList(
            "com.jcloud.design.pattern.behavior.strategy"
    );

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        log.info("------ handerContextProcessor  start ------");
        Map<String,Class> headerMap = new HashMap<>();
        classScanner.scanByAnno(scanpkg,HanderType.class).forEach(cls ->{
            String s =  ((HanderType)cls.getAnnotation(HanderType.class)).value();
            headerMap.put(s,cls);
        });
        HanderContext orderContext = new HanderContext(headerMap);
        configurableListableBeanFactory.registerSingleton(HanderContext.class.getName(),orderContext);
    }
}
