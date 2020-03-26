package com.woody.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    /**
     * 设置默认访问首页的第一种方式：
     * 发起任何请求都到template下的index.html而不是pubic下的login.html
     * @return
     */
//    @RequestMapping({"/", "/index.html"})
//    public String login() {
//        return "login";
//    }

//    @RequestMapping("/main.html")
//    public String mainProcess() {
//        return "dashboard";
//    }

    /**
     * 为了防止表单重复提交，使用重定向
     * 本来是在MVC扩展配置类中实现的，但因为类的问题，只能在这里调用
     * @return
     */

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {

        return "Hello World!";
    }

    @RequestMapping("/success")
    public String success() {

        return "success";
    }
}
