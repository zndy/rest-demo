package com.johnny.restdemo.controller;

import com.johnny.restdemo.entity.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @RequestMapping(value="/show", method = RequestMethod.GET)
    public @ResponseBody Employee showMe(){
        return new Employee().setId(1).setName("Johnny").setAge(36);
    }

    @RequestMapping(value="/showstr", method = RequestMethod.GET)
    public String show(){
//        return new Employee().setId(1).setName("Johnny").setAge(36).toString();
        return new String("hallo world");
    }


}
