package com.zhr.boot.config;

import com.zhr.boot.interceptor.LoginInterceptor;
import com.zhr.boot.interceptor.LogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web MVC 配置类
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加日志拦截器
        registry.addInterceptor(new LogInterceptor())
                .addPathPatterns("/**")  // 拦截所有路径
                .order(1);               // 设置拦截器执行顺序
        
        // 添加登录拦截器
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")  // 拦截所有路径
                .excludePathPatterns(
                        "/login",           // 放行登录页面
                        "/user/login",      // 放行登录请求
                        "/static/**",       // 放行静态资源
                        "/css/**",
                        "/js/**",
                        "/images/**",
                        "/fonts/**",
                        "/error",           // 放行错误页面
                        "/favicon.ico"      // 放行图标
                )
                .order(2);               // 设置拦截器执行顺序
    }
}