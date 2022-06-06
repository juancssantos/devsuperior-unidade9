package com.devsuperior.movieflix.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.devsuperior.movieflix.entites.Review;
import com.devsuperior.movieflix.entites.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String email;
	@JsonIgnore
	public List<ReviewDTO> reviews = new ArrayList<>();

	
 
	public UserDTO() {
	}

	public UserDTO(Long id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public UserDTO(User entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
	}
	
	public UserDTO(User entity, Set<Review> reviews) {
		this(entity);
		reviews.forEach(x -> this.reviews.add(new ReviewDTO(x)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<ReviewDTO> getReviews() {
		return reviews;
	}
	
}
