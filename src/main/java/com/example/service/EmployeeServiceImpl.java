package com.example.service;

import com.example.domain.Employee;
import com.example.repositary.EmployeeRepositary;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepositary EmployeeRepositary;

    @Override
    public Employee getEmployee(Long id) {
        Employee employee=EmployeeRepositary.findById(id).orElseThrow(()->new RuntimeException());
        return null;
    }
}
