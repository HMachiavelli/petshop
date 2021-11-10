package com.henrique.petshop.utils;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.henrique.petshop.domain.Categoria;
import com.henrique.petshop.domain.Cidade;
import com.henrique.petshop.domain.Especie;
import com.henrique.petshop.domain.Estado;
import com.henrique.petshop.domain.Pet;
import com.henrique.petshop.domain.Produto;
import com.henrique.petshop.domain.Raca;
import com.henrique.petshop.repositories.CategoriaRepository;
import com.henrique.petshop.repositories.CidadeRepository;
import com.henrique.petshop.repositories.EspecieRepository;
import com.henrique.petshop.repositories.EstadoRepository;
import com.henrique.petshop.repositories.PetRepository;
import com.henrique.petshop.repositories.ProdutoRepository;
import com.henrique.petshop.repositories.RacaRepository;

@Component
public class Seeder {
	@Autowired
	CategoriaRepository categoriaRepo;
	@Autowired
	ProdutoRepository produtoRepo;
	@Autowired
	PetRepository petRepo;
	@Autowired
	RacaRepository racaRepo;
	@Autowired
	EspecieRepository especieRepo;
	@Autowired
	EstadoRepository estadoRepo;
	@Autowired
	CidadeRepository cidadeRepo;
	
	@PostConstruct
	public void seed() {
		Categoria cat1 = new Categoria(null, "Alimento");
		Categoria cat2 = new Categoria(null, "Cosmético");
		Categoria cat3 = new Categoria(null, "Remédio");
		
		Produto prd1 = new Produto(null, "Ração", 100.00);
		Produto prd2 = new Produto(null, "Sache", 80.00);
		Produto prd3 = new Produto(null, "Shampoo", 50.00);
		Produto prd4 = new Produto(null, "Vermifugo", 20.00);
		
		cat1.getProdutos().addAll(Arrays.asList(prd1, prd2));
		cat2.getProdutos().addAll(Arrays.asList(prd3));
		cat3.getProdutos().addAll(Arrays.asList(prd3, prd4));
		
		prd1.getCategorias().addAll(Arrays.asList(cat1));
		prd2.getCategorias().addAll(Arrays.asList(cat1));
		prd3.getCategorias().addAll(Arrays.asList(cat2));
		prd4.getCategorias().addAll(Arrays.asList(cat2, cat3));
		
		categoriaRepo.saveAll(Arrays.asList(cat1, cat2, cat3));
		produtoRepo.saveAll(Arrays.asList(prd1, prd2, prd3, prd4));
		
		Especie esp1 = new Especie(null, "Cachorro");
		Especie esp2 = new Especie(null, "Gato");
		
		Raca r1 = new Raca(null, "Shi Tzu");
		Raca r2 = new Raca(null, "Akita");
		Raca r3 = new Raca(null, "Persa");
		
		Pet pet1 = new Pet(null, "John", 6, esp1, r1);
		Pet pet2 = new Pet(null, "Hannah", 5, esp1, r2);
		Pet pet3 = new Pet(null, "Meowth", 8, esp2, r3);
		
		especieRepo.saveAll(Arrays.asList(esp1, esp2));
		racaRepo.saveAll(Arrays.asList(r1, r2, r3));
		petRepo.saveAll(Arrays.asList(pet1, pet2, pet3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Belo Horizonte", est1);
		Cidade c2 = new Cidade(null, "Capelinha", est1);
		Cidade c3 = new Cidade(null, "São Paulo", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1, c2));
		est2.getCidades().addAll(Arrays.asList(c3));
		
		estadoRepo.saveAll(Arrays.asList(est1, est2));
		cidadeRepo.saveAll(Arrays.asList(c1, c2, c3));
	}
}
