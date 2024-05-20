package com.example.controller;

import com.example.dao.TapaDAO;
import java.util.List;
import java.util.Optional;

import com.example.entity.Tapa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tapas")
public class TapaController {
	@Autowired
	private TapaDAO tapaDAO;
	
	@GetMapping
	public List<Tapa> getAll(){ 	 
		List<Tapa> tapas = null;

		tapas = tapaDAO.getAll();

		return tapas;
	}

	
	@GetMapping
	Optional<Tapa> read(Long id){
		return tapaDAO.read(id);
	}
	
	@GetMapping
	Long create(Tapa tapa) {
		return tapaDAO.create(tapa);
	}

}
