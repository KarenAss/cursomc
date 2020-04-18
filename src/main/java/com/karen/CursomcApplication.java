package com.karen;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.karen.domain.Categoria;
import com.karen.domain.Cidade;
import com.karen.domain.Cliente;
import com.karen.domain.Endereco;
import com.karen.domain.Estado;
import com.karen.domain.Produto;
import com.karen.domain.enums.TipoCliente;
import com.karen.repository.CategoriaRepository;
import com.karen.repository.CidadeRepository;
import com.karen.repository.ClienteRepository;
import com.karen.repository.EnderecoRepository;
import com.karen.repository.EstadoRepository;
import com.karen.repository.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository cat;
	@Autowired
	private ProdutoRepository prod;
	@Autowired
	private CidadeRepository cid;
	@Autowired
	private EstadoRepository est;
	@Autowired
	private EnderecoRepository end;
	@Autowired
	private ClienteRepository cli;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		cat.saveAll(Arrays.asList(cat1,cat2));
		prod.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade (null, "Campinas", est2);
		
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		est.saveAll(Arrays.asList(est1,est2));
		cid.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null,"Maria Silva","maria@gmail.com","36378912377",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323","93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834",cli1,c1);
		Endereco e2 = new Endereco(null, "Avenida Matos","105","Sala 800", "Centro", "38777012", cli1,c2);
		
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		cli.saveAll(Arrays.asList(cli1));
		end.saveAll(Arrays.asList(e1,e2));
		
	}

}
