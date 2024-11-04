package br.com.nevesfood.pagamentos.model;

import java.math.BigDecimal;

import org.hibernate.annotations.Columns;
import org.springframework.lang.NonNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;

/**
 * @author Romulo A. Neves
 * @since 25-10-2024
 */
@Entity
@Table(name = "pagamentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	@Positive
	private BigDecimal valor;
	@NotBlank
	@Size(max = 100)
	private String nome;
	@NotBlank
	@Size(max=19)
	private String numero;
	@NotBlank
	@Size(max=7)
	private String expiracao;
	@NotBlank
	@Size(min = 3, max=3)
	private String codigo;
	@NotNull
	@Enumerated(EnumType.STRING)
	private Status status;
	@NonNull
	@Column(name = "pedido_id")
	private Long pedidoId;
	@NonNull
	@Column(name = "forma_de_pagamento_id")
	private Long formaPagamentoId;
}
