package com.example.repositary;

import com.example.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositary extends JpaRepository<Employee,Long> {
}
