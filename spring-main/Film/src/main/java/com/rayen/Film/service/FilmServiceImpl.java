package com.rayen.Film.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rayen.Film.dto.FilmDTO;
import com.rayen.Film.entities.Film;
import com.rayen.Film.entities.Genre;
import com.rayen.Film.repos.FilmRepository;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;


@Service
public class FilmServiceImpl implements FilmService{
	
	@Autowired
	FilmRepository FilmRepository;
	@Autowired
	ModelMapper modelMapper;


	/*@Override
	public Film saveFilm(Film f) {
		
		return FilmRepository.save(f);
	}*/
	@Override
	public FilmDTO saveFilm(FilmDTO f) {
		return convertEntityToDto(FilmRepository.save(convertDtoToEntity(f)));
	}
	@Override
	public FilmDTO getFilm(Long id) {
		return convertEntityToDto(FilmRepository.findById(id).get());
	}
	@Override
	public List<FilmDTO> getAllFilm() {
		return FilmRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}




	@Override
	public FilmDTO updateFilm(FilmDTO f) {
		return convertEntityToDto(FilmRepository.save(convertDtoToEntity(f)));
	}


	@Override
	public void deleteFilm(Film f) {
		FilmRepository.delete(f);
		
	}

	@Override
	public void deleteFilmById(Long id) {
		FilmRepository.deleteById(id);
		
	}



	@Override
	public List<Film> findByNomFilm(String nom) {
		return FilmRepository.findByNomFilm(nom);
	}

	@Override
	public List<Film> findByNomFilmContains(String nom) {
		return FilmRepository.findByNomFilmContains(nom);
	}

	@Override
	public List<Film> findByNomdescription(String nom, String description) {
		return FilmRepository.findByNomdescription(nom,description);
	}

	@Override
	public List<Film> findByGenre(Genre Genre) {
		return FilmRepository.findByGenre(Genre);
	}

	@Override
	public List<Film> findByGenreIdGenre(Long id) {
		return FilmRepository.findByGenreIdGenre(id);
	}


	@Override
	public List<Film> findByOrderByNomFilmAsc() {
		return FilmRepository.findByOrderByNomFilmAsc();
	}

	@Override
	public List<Film> trierFilmNomsdescription() {
		return FilmRepository.trierFilmNomsdescription();
	}
	@Override
	public FilmDTO convertEntityToDto(Film film) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		FilmDTO filmDTO = modelMapper.map(film, FilmDTO.class);
		return filmDTO;
	}
	@Override
	public Film convertDtoToEntity(FilmDTO filmDTO) {
		Film film = new Film();
		film = modelMapper.map(filmDTO, Film.class);
		return film;

	}





}
