package com.demerson.Spring.Data.JPA.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "client")
public class Client extends Person {
   
	@OneToMany(mappedBy = "client")
	private List<Project> projects;
}
