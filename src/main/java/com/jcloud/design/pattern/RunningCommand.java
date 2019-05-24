package com.jcloud.design.pattern;

import com.jcloud.design.pattern.behavior.strategy.HanderContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author mwl
 * @date 2019/5/24 11:22
 */
@Component
public class RunningCommand  implements ApplicationRunner {

    @Autowired
    HanderContext handerContext;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        handerContext.getOrderStrategyInstance("1").handler("采购策略");

    }
}
