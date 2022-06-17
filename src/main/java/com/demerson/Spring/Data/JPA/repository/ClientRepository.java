package com.demerson.Spring.Data.JPA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.demerson.Spring.Data.JPA.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
	
	@EntityGraph(attributePaths = "address")
	List<Client> findAll();

}
