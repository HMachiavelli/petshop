package com.henrique.petshop.utils;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.henrique.petshop.domain.Categoria;
import com.henrique.petshop.domain.Produto;
import com.henrique.petshop.repositories.CategoriaRepository;
import com.henrique.petshop.repositories.ProdutoRepository;

@Component
public class Seeder {
	@Autowired
	CategoriaRepository categoriaRepo;
	@Autowired
	ProdutoRepository produtoRepo;
	
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
	}
}
