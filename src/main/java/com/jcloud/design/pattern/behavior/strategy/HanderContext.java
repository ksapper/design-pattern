package com.jcloud.design.pattern.behavior.strategy;

import com.jcloud.design.pattern.utils.SpringBeanTool;

import java.util.Map;

/**
 * 环境对象
 *
 * @author mwl
 * @date 2019/5/23 13:27
 */
public class HanderContext {

    private Map<String, Class> handerMap;

    public HanderContext(Map<String, Class> handerMap) {
        this.handerMap = handerMap;
    }

    public HanderStrategy getOrderStrategyInstance(String type) throws IllegalAccessException {
        Class cls = handerMap.get(type);
        if (cls == null) {
            throw new IllegalAccessException("not found hander type" + type);

        }
        return (HanderStrategy) SpringBeanTool.getBean(cls);
    }

}
