package com.karen.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karen.domain.Categoria;
import com.karen.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository rep;
	
	public Categoria buscar(Integer id) {
		
		Optional<Categoria> categoria = rep.findById(id);
		return categoria.orElse(null); 

	}
}
