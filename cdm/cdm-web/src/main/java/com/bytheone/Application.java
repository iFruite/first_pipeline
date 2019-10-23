package com.bytheone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author ArtLinty
 * @date 2018/1/1.
 * @email liu.tingli@qq.com
 */

@EnableWebMvc
@SpringBootApplication
@EnableTransactionManagement
@ComponentScan({"com.bytheone", "org.activiti"})
@MapperScan(basePackages = {"com.bytheone.mapper"})
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
//    String[] names = applicationContext.getBeanDefinitionNames();
        //1.8 forEach循环
//    Arrays.asList(names).forEach(System.out::println);
        System.out.println("Server starts successfully!");
    }


}
