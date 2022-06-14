package com.demerson.Spring.Data.JPA.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "address")
public class Address extends com.demerson.Spring.Data.JPA.entity.Entity {

	@Column(nullable = false, length = 2)
	@Enumerated(EnumType.STRING)
	private UF uf;

	@Column(nullable = false)
	private String cidade;

	@Column(nullable = false)
	private String bairro;

	@Column(nullable = false)
	private String logradouro;

	@Column(nullable = false)
	private String cep;

	@Column(nullable = false)
	private String numero;

	private String complemento;

	@Override
	public String toString() {
		StringBuilder enderecoCompleto = new StringBuilder();
		enderecoCompleto.append(logradouro).append(", n° ").append(numero).append(", ").append(complemento)
				.append(" - ").append(bairro).append(". ").append(uf.getDescricao()).append(" - ").append(cidade)
				.append(". CEP: ").append(cep);

		return enderecoCompleto.toString();
	}
}
