package com.bytheone.config;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Configuration;

/**
 * @author ArtLinty
 * @date 2018/1/31.
 * @email liu.tingli@qq.com
 */
@Configuration
public class BeanName implements BeanNameAware {

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware-------->:" + name);
    }
}
