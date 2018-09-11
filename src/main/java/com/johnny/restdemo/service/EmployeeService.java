package com.johnny.restdemo.service;

import com.johnny.restdemo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {
    private Map<Long, Employee> employees = new HashMap<>();

    public EmployeeService() {
        employees.put(1L, new Employee(1, "Johnny", 36));
        employees.put(2L, new Employee(2, "Aimee", 36));
        employees.put(3L, new Employee(3, "Rainer", 30));
        employees.put(4L, new Employee(4, "Matthias", 31));
        employees.put(5L, new Employee(5, "Amgad", 27));
        employees.put(6L, new Employee(6, "Bernhard", 32));
        employees.put(7L, new Employee(7, "Florian", 25));
    }

    public Employee getById(long id) {
        return employees.get(id);
    }

    public Map<Long, Employee> getAll() {
        return employees;
    }

    public Employee addEmployee(Employee employee) {
        employees.put(employee.getId(), employee);
        return employee;
    }

    public void deleteById(Long id) {
        employees.remove(id);
    }
}
