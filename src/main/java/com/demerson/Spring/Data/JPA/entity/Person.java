package com.demerson.Spring.Data.JPA.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class Person extends Entity {

	@Column(nullable = false, length = 80)
	private String nome;

	@Column(nullable = false, length = 14, unique = true)
	private String cpf;

	@Column(nullable = false, length = 15)
	private String telefone;

	@Column(nullable = false, length = 80, unique = true)
	private String email;

	@Column(name = "data_nascimento", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataNascimento;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id_fk", nullable = false)
	private Address address;
}
