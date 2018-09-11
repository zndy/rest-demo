package com.johnny.restdemo.controller;

import com.johnny.restdemo.entity.Employee;
import com.johnny.restdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //--------get-------------
    //altmodisch
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hallo world";
    }

    @RequestMapping(value = "/who1", method = RequestMethod.GET)
    public @ResponseBody
    Employee who1() {
        return employeeService.getById(1);
    }

    @GetMapping("/who2")
    Employee who2() {
        return employeeService.getById(2);
    }

    @GetMapping("/who/{id}")
    Employee one(@PathVariable Long id) {
        return employeeService.getById(id);
    }

    @GetMapping("all")
    Map<Long, Employee> all() {
        return employeeService.getAll();
    }

    //----------post-----------------
    @PostMapping("/changeName")
    Employee changeEmployeeName(@RequestBody Employee newEmployee) {
        return newEmployee.setName("afterChange");
    }

}
