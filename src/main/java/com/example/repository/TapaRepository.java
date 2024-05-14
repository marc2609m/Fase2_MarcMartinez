package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Tapa;

public interface TapaRepository extends JpaRepository<Tapa, Long>{
	@Query("INSERT INTO TAPAS (ID, NOMBRE, DESCRIPCION, PRECIO, TIPO, ENCARTA) \r\n"
			+ "VALUES (:tapa.getId(), :tapa.getNombre(), :tapa.getDescripcion(), :tapa.getPrecio(), :tapa.getTipo(), :tapa.isEnCarta())" )
	Long create(Tapa tapa);
	@Query("SELECT t FROM Tapas t WHERE t.id = :id")
	Optional<Tapa> read(Long id);
	@Query("SELECT t FROM Tapas t")
	List<Tapa> getAll();
}
