package cn.lee.jason.simple2.config;

import cn.lee.jason.simple2.core.CustomerBo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jason on 17/2/13.
 */
@Configuration
public class CustomerConfig {

    @Bean(name="customer")
    public CustomerBo customerBo(){
        return new CustomerBo();
    }
}
