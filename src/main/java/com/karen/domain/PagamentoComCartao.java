package com.karen.domain;

import javax.persistence.Entity;

import com.karen.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento{
	
	private static final long serialVersionUID = 1L;
	

	private Integer numeroDeParcelas;
	
	public PagamentoComCartao() {
		
	}

	

	public PagamentoComCartao(Integer id2, EstadoPagamento estado2, Pedido pedido2, Integer numeroDeParcelas) {
		super(id2, estado2, pedido2);
		// TODO Auto-generated constructor stub
		this.numeroDeParcelas = numeroDeParcelas;
	}



	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
}
