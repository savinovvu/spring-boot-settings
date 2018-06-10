package ru.inbox.savinov_vu.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;



@Service
public class EmployeeService {
     EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }
    public Employee getMaxSalariedEmployee()
    {
        List<Employee> emps = employeeRepository.findAll();
        Employee employee = emps.stream().max(Comparator.comparingInt(Employee::getSalary)).orElseGet(null);
        return employee;
    }
}
