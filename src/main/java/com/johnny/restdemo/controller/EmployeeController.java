package com.johnny.restdemo.controller;

import com.johnny.restdemo.entity.Employee;
import com.johnny.restdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.time.LocalTime;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class EmployeeController {

    private ExecutorService nonBlockingService = Executors.newCachedThreadPool();

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

    //----------------------------
    @PostMapping("/create")
    Employee createEmployee(@RequestBody Employee newEmployee) {
        return employeeService.addEmployee(newEmployee);
    }

    @PutMapping("/edit/{id}")
    Employee editEmployee(@RequestBody Employee template, @PathVariable Long id) {
        Employee employee = employeeService.getById(id);
        employee.setName(template.getName());
        employee.setAge(template.getAge());
        return employee;
    }

    @DeleteMapping("/delete/{id}")
    void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteById(id);
    }

    //------------------sse------------------------------------
    @GetMapping("/sse")
    public SseEmitter handleSse() {
        SseEmitter emitter = new SseEmitter(0L);//0: without timeout
        nonBlockingService.execute(() -> {
            try {
                for (int i = 0; i < 50; i++) {
                    emitter.send("/sse" + " @ " + new Date());
                    Thread.sleep(2000);
                }
                // we could send more events
                emitter.complete();
            } catch (Exception ex) {
                emitter.completeWithError(ex);
            }
        });
        return emitter;
    }

}
