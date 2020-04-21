package com.karen.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karen.domain.Pedido;
import com.karen.repository.PedidoRepository;
import com.karen.service.exception.ObjectNotFoundException;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository rep;
	
	public Pedido buscar(Integer id) {
		
		Optional<Pedido> pedido = rep.findById(id);
		if(pedido == null) {
			return pedido.orElseThrow(() -> new ObjectNotFoundException(
					 "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName())); 

		}
		return pedido.get(); 
		

	}
}
