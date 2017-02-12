package cn.lee.jason.simple2.config;

import cn.lee.jason.simple2.core.SchedulerBo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jason on 17/2/13.
 */
@Configuration
public class SchedulerConfig {

    @Bean(name="scheduler")
    public SchedulerBo suchedulerBo(){
        return new SchedulerBo();
    }
}
