package com.example.dao;

import com.example.entity.Tapa;

import java.util.List;
import java.util.Optional;

public interface TapaDAO{
	Long create(Tapa tapa);
	Optional<Tapa> read(Long id);
	List<Tapa> getAll();
}
