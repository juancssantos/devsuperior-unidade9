package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.dto.MovieByGenreDTO;
import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.entites.Movie;
import com.devsuperior.movieflix.entites.Review;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repository;
	 
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Transactional(readOnly = true)
	@PreAuthorize("hasAnyRole('MEMBER','VISITOR')")
	public MovieDTO findById(Long id) {
		Optional<Movie> obj = repository.findById(id);
		Movie entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new MovieDTO(entity, new GenreDTO(entity.getGenre()));
		
	}
	
	@Transactional(readOnly = true)
	@PreAuthorize("hasAnyRole('MEMBER','VISITOR')")
	public Page<MovieDTO> findAll(Pageable pageable) {
		pageable =   PageRequest.of(0,20, Sort.by("title"));
		Page<Movie> obj = repository.findAll(pageable);
		return obj.map(x -> new MovieDTO(x, new GenreDTO(x.getGenre())));
		
	}
		
	@Transactional(readOnly = true)
	@PreAuthorize("hasAnyRole('MEMBER','VISITOR')")
	public Page<MovieByGenreDTO> MovieByGenre(Long id, Pageable pageable) { 
		 
	 
		pageable =  PageRequest.of(0,20, Sort.by("title"));
		Page<Movie> obj = (id==0 ? repository.findAll(pageable) : repository.MovieByGenre(id, pageable));
	    
		if (obj.isEmpty())
			throw new ResourceNotFoundException("Id not found " + id);

		return obj.map(x -> new MovieByGenreDTO(x));
		
	}
	
	@Transactional(readOnly = true)
	@PreAuthorize("hasAnyRole('MEMBER','VISITOR')")
	public List<ReviewDTO> MovieReviews(Long id) { 
     
 		List<Review> reviews =reviewRepository.findByMovie(id);
    
		return reviews.stream().map(x-> new ReviewDTO(x,new UserDTO(x.getUser()))).collect(Collectors.toList());
	 
 		 
		
		 
	}
 
}


