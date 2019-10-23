package com.bytheone.config;

import com.bytheone.core.annotation.LogAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ArtLinty
 * @date 2018/1/3.
 * @email liu.tingli@qq.com
 */
@Configuration
public class LogConfig {

    @Bean(name = "logAspect")
    public LogAspect getLogAspect() {
        return new LogAspect();
    }

}
