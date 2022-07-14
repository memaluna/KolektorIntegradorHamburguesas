package edu.cursokolektor.proyectointegrador.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import edu.cursokolektor.proyectointegrador.bo.Hamburguesa;

@Repository
public interface HamburguesaRepository extends JpaRepository<Hamburguesa, Long>{

	List<Hamburguesa> findAllByOrderById();
	
	@Query("select p from Hamburguesa as p where p.nombre like ?1%")
	List<Hamburguesa> buscarHamburguesa(String nombre);

	@Query("select p from Hamburguesa as p where p.nombre like ?1% or p.precio >= ?2")
	List<Hamburguesa> buscarHamburguesa(String nombre, Double precio);
}
