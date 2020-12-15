package com.br.pedrofernandes.apprestaurante.Repositories;

import com.br.pedrofernandes.apprestaurante.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
