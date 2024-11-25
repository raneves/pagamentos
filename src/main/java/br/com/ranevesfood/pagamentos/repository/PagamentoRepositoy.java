package br.com.ranevesfood.pagamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ranevesfood.pagamentos.model.Pagamento;

public interface PagamentoRepositoy extends JpaRepository<Pagamento, Long> {
}
