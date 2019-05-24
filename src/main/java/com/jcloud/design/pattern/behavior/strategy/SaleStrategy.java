package com.jcloud.design.pattern.behavior.strategy;

import com.jcloud.design.pattern.behavior.strategy.annotate.HanderType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 销售订单
 *
 * @author mwl
 * @date 2019/5/23 13:23
 */
@Component
@HanderType("2")
@Slf4j
public class SaleStrategy implements HanderStrategy {

    @Override
    public boolean handler(String s) {
        log.info("--"+s+"--");
        return false;
    }
}
