package com.example.daoimpl;

import java.util.List;
import java.util.Optional;

import com.example.dao.TapaDAO;
import com.example.entity.Tapa;
import com.example.repository.TapaRepository;

public class TapaDAOImpl implements TapaDAO{
	
	private TapaRepository tapaRepository;

	@Override
	public Long create(Tapa tapa) {
		if(tapa.getId() != null) {
            System.out.println("Codigo nulo");
        }
        
        Long id = System.currentTimeMillis();
        
        tapa.setId(id);

        tapaRepository.save(tapa); 
        return id;
	}

	@Override
	public Optional<Tapa> read(Long id) {
		return tapaRepository.findById(id);
	}

	@Override
	public List<Tapa> getAll() {
		return tapaRepository.getAll();
	}

}
