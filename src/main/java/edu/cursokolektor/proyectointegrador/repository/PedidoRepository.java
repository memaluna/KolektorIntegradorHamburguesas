package edu.cursokolektor.proyectointegrador.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.cursokolektor.proyectointegrador.bo.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	List<Pedido> findAllByOrderById();
}
