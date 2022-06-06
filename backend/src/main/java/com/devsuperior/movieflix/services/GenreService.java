package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.entites.Genre;
import com.devsuperior.movieflix.repositories.GenreRepository;

@Service
public class GenreService {
	
	@Autowired
	private GenreRepository repository;
	
	@Transactional(readOnly = true)
	@PreAuthorize("hasAnyRole('MEMBER','VISITOR')")
	public List<GenreDTO> findAll() {
		 
		List<Genre> obj = repository.findAll();
		return obj.stream().map(x -> new GenreDTO(x)).collect(Collectors.toList());
		
	}
	

}
