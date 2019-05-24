package com.jcloud.design.pattern.behavior.strategy.annotate;

import java.lang.annotation.*;

/**
 * @author mwl
 * @date 2019/5/23 14:15
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface HanderType {

    String value();
}
