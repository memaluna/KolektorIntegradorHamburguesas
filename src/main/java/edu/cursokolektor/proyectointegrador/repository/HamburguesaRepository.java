package edu.cursokolektor.proyectointegrador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.cursokolektor.proyectointegrador.bo.Hamburguesa;

@Repository
public interface HamburguesaRepository extends JpaRepository<Hamburguesa, Long>{

	List<Hamburguesa> findAllByOrderById();
}
