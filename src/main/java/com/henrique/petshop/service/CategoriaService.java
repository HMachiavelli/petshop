package com.henrique.petshop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henrique.petshop.domain.Categoria;
import com.henrique.petshop.repositories.CategoriaRepository;
import com.henrique.petshop.service.exceptions.ObjetoNaoEncontradoException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado. ID: " + id + ", Tipo: " + Categoria.class.getCanonicalName()));
	}
}
