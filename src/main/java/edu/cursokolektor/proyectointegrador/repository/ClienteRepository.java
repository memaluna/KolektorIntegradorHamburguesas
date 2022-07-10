package edu.cursokolektor.proyectointegrador.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.cursokolektor.proyectointegrador.bo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	List<Cliente> findAllByOrderById();
}
