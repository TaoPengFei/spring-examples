package cn.lee.jason.simple.config;

import cn.lee.jason.simple.hello.HelloWorld;
import cn.lee.jason.simple.hello.impl.HelloWorldImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jason on 17/2/9.
 */
@Configuration
public class AppConfig {

    @Bean(name = "helloBean")
    public HelloWorld helloWorld() {
        return new HelloWorldImpl();
    }
}
