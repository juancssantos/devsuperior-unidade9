package com.devsuperior.movieflix.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.movieflix.entites.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	  
	
	@Query("SELECT DISTINCT obj FROM Movie obj "
			+ " WHERE :id IS NULL OR obj.genre.id = :id ")
	Page<Movie> MovieByGenre(Long id, Pageable pageable);
 

	@Query("SELECT DISTINCT obj FROM Movie obj "
			+ " JOIN FETCH obj.reviews rv "
			+ " WHERE obj.id =:id")
	List<Movie> findMovieWithReviews(Long id);
 
}
