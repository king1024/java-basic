package com.king.spring1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.king.spring1.interceptor.AdeptInterceptor;
import com.king.spring1.interceptor.ManageInterceptor;

/**
 * @author duanyong
 * 2019年4月11日 上午10:40:31
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter{
     
    public void addInterceptors(InterceptorRegistry registry) {
         //注册拦截器 拦截规则
        //多个拦截器时 以此添加 执行顺序按添加顺序
        registry.addInterceptor(getHandlerInterceptor()).addPathPatterns("/*");
     }

    @Bean
    public static ManageInterceptor getHandlerInterceptor() {
        return new ManageInterceptor();
    }
    /*
    @Bean
    public static AdeptInterceptor getAdeptInterceptor() {
        return new AdeptInterceptor();
    }
    */
}
