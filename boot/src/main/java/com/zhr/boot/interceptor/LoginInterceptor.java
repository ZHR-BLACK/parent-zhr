package com.zhr.boot.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求路径
        String requestURI = request.getRequestURI();
        
        // 放行登录页面和登录请求
        if (requestURI.contains("/login") || requestURI.contains("/static/")) {
            return true;
        }
        
        // 检查session中是否有用户信息
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        
        if (user == null) {
            // 未登录，重定向到登录页面
            log.info("未登录，重定向到登录页面");
            response.sendRedirect("/user/login");
            return false;
        }
        
        // 已登录，放行
        return true;
    }
}