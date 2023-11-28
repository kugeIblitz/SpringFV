package com.rayen.Film.entities;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFilm;
	private String nomFilm;
	private String descriptionFilm;
	private Date dateCreation;
	@ManyToOne
	private Genre genre;
	@OneToOne
	private Image image;




	/*public Film() {
		super();
	}*/
	
	/*public Film(String nomFilm, String descriptionFilm, Date dateCreation,Genre genre) {
		super();
		this.nomFilm = nomFilm;
		this.descriptionFilm = descriptionFilm;
		this.dateCreation = dateCreation;
		this.genre = genre;
	}

	public long getIdFilm() {
		return idFilm;
	}
	public void setIdFilm(Long idFilm) {
		this.idFilm = idFilm;
	}
	public String getNomFilm() {
		return nomFilm;
	}
	public void setNomFilm(String nomFilm) {
		this.nomFilm = nomFilm;
	}
	public String getdescriptionFilm() {
		return descriptionFilm;
	}
	public void setdescriptionFilm(String descriptionFilm) {
		this.descriptionFilm = descriptionFilm;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return "Film [idFilm=" + idFilm + ", nomFilm=" + nomFilm + ", descriptionFilm=" + descriptionFilm + ", DateCreation="
				+ dateCreation + "]";
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}*/
	
	
	
	
}
