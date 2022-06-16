package com.demerson.Spring.Data.JPA.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@javax.persistence.Entity
@Table(name = "project")
public class Project extends Entity {
	
	@Column(nullable = false)
	private String nome;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String descricao;

	@Column(name = "data_inicio", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataInicio;

	@Column(name = "data_fim")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataFim;

	@ManyToOne
	@JoinColumn(name = "cliente_id_fk", nullable = false)
	private Client client;

	@ManyToOne
	@JoinColumn(name = "lider_id_fk", nullable = false)
	private Employee lider;

	@Column(nullable = false)
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	private BigDecimal orcamento;

	@Column(nullable = false)
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	private BigDecimal gastos;

	@ManyToMany
	@JoinTable(
			name = "projeto_funcionario", 
			joinColumns = @JoinColumn(name = "projeto_id_fk"), 
			inverseJoinColumns = @JoinColumn(name = "funcionario_id_fk")
			)
	private java.util.List<Employee> equipe;
	
	
	
}
