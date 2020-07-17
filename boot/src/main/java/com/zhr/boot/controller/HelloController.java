package com.zhr.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName HelloController
 * @Date 2020-06-08 18:24
 * @description
 * /：映射到index.html
 * /hello：映射到hello.html
 *
 * 根据配置，Spring Security提供了一个过滤器来拦截请求并验证用户身份。如果用户身份认证失败，页面就重定向到/login?error，
 * 并且页面中会展现相应的错误信息。若用户想要注销登录，可以通过访问/login?logout请求，在完成注销之后，页面展现相应的成功消息。
 *
 * 到这里，我们启用应用，并访问http://localhost:8080/，可以正常访问。
 * 但是访问http://localhost:8080/hello的时候被重定向到了http://localhost:8080/login页面，
 * 因为没有登录，用户没有访问权限，通过输入用户名user和密码password进行登录后，跳转到了Hello World页面，
 * 再通过访问http://localhost:8080/login?logout，就可以完成注销操作。
 **/
@Controller
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
