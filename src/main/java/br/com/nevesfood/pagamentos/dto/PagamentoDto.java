package br.com.nevesfood.pagamentos.dto;

import java.math.BigDecimal;

import br.com.nevesfood.pagamentos.model.Status;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Romulo A. Neves
 * @since 25-10-2024
 */
@Getter
@Setter
public class PagamentoDto {

	private Long id;	
	private BigDecimal valor;	
	private String nome;	
	private String numero;
	private String expiracao;
	private String codigo;
	private Status status;
	private Long pedidoIdLong;
	private Long formaPagamentoIdLong;
}