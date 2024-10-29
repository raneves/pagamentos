package br.com.nevesfood.pagamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nevesfood.pagamentos.model.Pagamento;

/**
 * @author Romulo A. Neves
 * @since 25-10-2024
 */
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

}
