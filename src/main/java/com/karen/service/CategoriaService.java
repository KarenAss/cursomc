package com.karen.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karen.domain.Categoria;
import com.karen.repository.CategoriaRepository;
import com.karen.service.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository rep;
	
	public Categoria buscar(Integer id) {
		
		Optional<Categoria> categoria = rep.findById(id);
		if(categoria == null) {
			return categoria.orElseThrow(() -> new ObjectNotFoundException(
					 "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName())); 

		}
		return categoria.get(); 
		

	}
}
