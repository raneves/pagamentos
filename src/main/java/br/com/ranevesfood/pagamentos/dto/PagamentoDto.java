package br.com.ranevesfood.pagamentos.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

import br.com.ranevesfood.pagamentos.model.Status;

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
    private Long formaDePagamentoId;
    private Long pedidoId;


}
