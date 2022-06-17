package com.demerson.Spring.Data.JPA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demerson.Spring.Data.JPA.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@EntityGraph(attributePaths = {"address","office"})
	List<Employee> findAll();
	
	
	@Query("select f from Employee f where f.office.nome = :cargoNome")
	List<Employee> buscarPorCargo(String cargoNome);
	

	@Query("select f from Employee f where f.office.nome <> :cargoNome")
	List<Employee> buscarPorCargoExceto(String cargoNome);
}
