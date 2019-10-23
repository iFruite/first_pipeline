package com.bytheone.core.BootListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.stereotype.Component;

/**
 * @author ArtLinty
 * @date 2018/1/6.
 * @email liu.tingli@qq.com
 */
@Component
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("-------contextInitialized-----------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("------------contextDestroyed-------------");
    }
}
