package com.demerson.Spring.Data.JPA.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "employee")
public class Employee extends Person {

	@Column(name = "data_admissao", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataAdmissao;

	@Column(name = "data_demissao")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataDemissao;
	
	

}
