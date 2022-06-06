package com.devsuperior.movieflix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.movieflix.entites.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	
	@Query("SELECT DISTINCT obj FROM Review obj "
 			+ " WHERE obj.movie.id =:movieID")
	 List<Review> findByMovie(Long movieID);

}
