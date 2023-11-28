package com.rayen.Film.service;


import java.util.List;

import com.rayen.Film.dto.FilmDTO;
import com.rayen.Film.entities.Film;
import com.rayen.Film.entities.Genre;

public interface FilmService {
	//Film saveFilm(Film f);
	FilmDTO saveFilm(FilmDTO f);
	FilmDTO getFilm(Long id);
	List<FilmDTO> getAllFilm();

	//Film updateFilm(Film f);
	FilmDTO updateFilm(FilmDTO f);
	void deleteFilm(Film f);
	void deleteFilmById(Long id);
	//Film getFilm(Long id);
	//List<Film> getAllFilm();
	List<Film> findByNomFilm(String nom);
	List<Film> findByNomFilmContains(String nom);
	List<Film> findByNomdescription (String nom, String description);
	List<Film> findByGenre (Genre genre);
	List<Film> findByGenreIdGenre(Long id);
	List<Film> findByOrderByNomFilmAsc();
	List<Film> trierFilmNomsdescription();
	FilmDTO convertEntityToDto(Film film);
	Film convertDtoToEntity(FilmDTO filmDTO);


}
