package com.demerson.Spring.Data.JPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demerson.Spring.Data.JPA.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
