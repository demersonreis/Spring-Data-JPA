package com.demerson.Spring.Data.JPA.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "office")
public class Office extends com.demerson.Spring.Data.JPA.entity.Entity {
	
	@Column(nullable = false, length = 40, unique = true)
	private String nome;

}
