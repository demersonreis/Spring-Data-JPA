package com.demerson.Spring.Data.JPA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.demerson.Spring.Data.JPA.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
   
	@EntityGraph(attributePaths = {"lider","client"})
	List<Project> findAll();
	
	
}
