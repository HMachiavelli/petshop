package com.henrique.petshop.utils;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.henrique.petshop.domain.Categoria;
import com.henrique.petshop.repositories.CategoriaRepository;

@Component
public class Seeder {
	@Autowired
	CategoriaRepository categoriaRepo;
	
	@PostConstruct
	public void seed() {
		Categoria cat1 = new Categoria(null, "Alimento");
		Categoria cat2 = new Categoria(null, "Cosmético");
		Categoria cat3 = new Categoria(null, "Remédio");
		
		categoriaRepo.saveAll(Arrays.asList(cat1, cat2, cat3));
	}
}
