package com.woody.controller;

import com.woody.dao.EmployeeDao;
import com.woody.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * 员工控制器
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    /**
     * 查询所有，返回list页面
     * prefix:classpath:templates/
     * suffix:.html
     *
     * 说好的用GET方式查询所有员工
     * @return
     */
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();

        // 放在请求域中
        model.addAttribute("emps",employees);

        // thymeleaf默认会拼串
        return "emp/list";
    }
}
