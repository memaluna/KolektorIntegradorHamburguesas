package edu.cursokolektor.proyectointegrador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.cursokolektor.proyectointegrador.bo.Ingrediente;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Long>{
	
	List<Ingrediente> findAllByOrderById();
	
}
