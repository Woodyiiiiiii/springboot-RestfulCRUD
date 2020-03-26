package com.woody.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

//    @RequestMapping(value = "/user/login", method = RequestMethod.POST)等价于下面的@PostMapping(还有@GetMapping,@DeleteMapping等)
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession httpSession) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            // 登录成功
            // 为防止表单重复提交，使用重定向
            httpSession.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }
        else {
            // 登录失败
            map.put("msg","username or password is wrong");
            return "login";
        }
    }
}
