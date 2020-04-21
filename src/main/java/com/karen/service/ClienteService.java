package com.karen.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karen.domain.Cliente;
import com.karen.repository.ClienteRepository;
import com.karen.service.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository rep;
	
	public Cliente buscar(Integer id) {
		
		Optional<Cliente> cliente = rep.findById(id);
		if(cliente == null) {
			return cliente.orElseThrow(() -> new ObjectNotFoundException(
					 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName())); 

		}
		return cliente.get(); 
		

	}
}
