package com.devsuperior.movieflix.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.devsuperior.movieflix.entites.Review;
import com.devsuperior.movieflix.entites.User;

public class ReviewDTO implements Serializable {
	
	 
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotBlank(message = "Campo requerido")
	private String text;  
	private Long movieId;
	private UserDTO user;
	public ReviewDTO () {
		
	}

	public ReviewDTO(Long id, String text, User user, Long movieId) {
		this.id = id;
		this.text = text; 
		this.movieId = movieId;
	}
	
	public ReviewDTO(Review entity) {
		this.id=entity.getId();
		this.text=entity.getText();
		this.movieId=entity.getMovie().getId();
	}
	
	public ReviewDTO(Review entity,UserDTO user) {
		this(entity);
		this.user = user;
	}
	
	public ReviewDTO(Review entity,Long movieId ) {
		this.id=entity.getId();
		this.text=entity.getText();
		this.movieId= movieId;
		
	}
	
 


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

 
 
 
	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	
 
 

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReviewDTO other = (ReviewDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	



}
