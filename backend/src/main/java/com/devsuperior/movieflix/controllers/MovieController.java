package com.devsuperior.movieflix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.MovieByGenreDTO;
import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@GetMapping(value = "/{id}")
 	public ResponseEntity<MovieDTO> findById(@PathVariable Long id) {
		MovieDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	 
	
	
	@GetMapping
 	public ResponseEntity<Page<MovieDTO>> findAll(Pageable pageable) {
		Page<MovieDTO> dto = service.findAll(pageable);
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(value = "/{id}/reviews")
 	public ResponseEntity<List<ReviewDTO>> MovieReviews(@PathVariable Long id) {
		List<ReviewDTO> dto = service.MovieReviews(id);
		return ResponseEntity.ok().body(dto);
	}

	
	@RequestMapping( 
			  params = { "genreId" }, 
			  method = RequestMethod.GET)
	@ResponseBody
 	public ResponseEntity<Page<MovieByGenreDTO>> MovieBYGenre( @RequestParam Long genreId, Pageable pageable) {
		Page<MovieByGenreDTO> dto = service.MovieByGenre(genreId, pageable);
		return ResponseEntity.ok().body(dto);
	}


}
