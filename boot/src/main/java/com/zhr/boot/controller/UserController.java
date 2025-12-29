package com.zhr.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * 用户控制器 - 用于测试拦截器
 */
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 登录页面
     */
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    /**
     * 处理登录请求
     */
    @PostMapping("/login")
    public String login(@RequestParam String username, 
                        @RequestParam String password, 
                        HttpSession session) {
        log.info("username={}, password={}", username, password);
        // 简单的验证逻辑（实际项目中应该使用数据库验证）
        if ("admin".equals(username) && "123456".equals(password)) {
            // 将用户信息存入session
            session.setAttribute("user", username);
            return "redirect:/user/dashboard";
        }
        return "redirect:/user/login?error=1";
    }

    /**
     * 用户首页（需要登录才能访问）
     */
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    /**
     * 退出登录
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        session.invalidate();
        return "redirect:/user/login";
    }
}