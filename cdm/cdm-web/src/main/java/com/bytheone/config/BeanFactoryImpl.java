package com.bytheone.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.annotation.Configuration;

/**
 * @author ArtLinty
 * @date 2018/1/31.
 * @email liu.tingli@qq.com
 */
@Configuration
public class BeanFactoryImpl implements BeanFactoryAware {


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware------->" + beanFactory);
    }
}
