package cn.lee.jason.simple2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by jason on 17/2/13.
 */
@Configuration
@Import({ CustomerConfig.class, SchedulerConfig.class })
public class AppConfig {
}
