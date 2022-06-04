package com.demerson.Spring.Data.JPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demerson.Spring.Data.JPA.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
