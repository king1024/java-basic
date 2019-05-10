package com.king.spring1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.king.spring1.interceptor.ManageInterceptor;

@SpringBootApplication
@MapperScan("com.king.spring1.mapper")
public class Spring1Application {

	@Configuration
    static class WebMvcConfigurer extends WebMvcConfigurerAdapter{
        //增加拦截器
        public void addInterceptors(InterceptorRegistry registry){
            registry.addInterceptor(new ManageInterceptor())    //指定拦截器类
                    .addPathPatterns("/main");        //指定该类拦截的url
        }
    }

	public static void main(String[] args) {
		SpringApplication.run(Spring1Application.class, args);
	}

}
