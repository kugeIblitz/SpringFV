package com.rayen.Film.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rayen.Film.dto.FilmDTO;
import com.rayen.Film.entities.Film;
import com.rayen.Film.service.FilmService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FilmRESTController {
	@Autowired
	public FilmService filmService;
	@RequestMapping(method = RequestMethod.GET)
	public List<FilmDTO> getAllFilm(){
		return filmService.getAllFilm();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public FilmDTO getFilmById(@PathVariable("id") Long id) {
		return filmService.getFilm(id);
	 }
	@RequestMapping(method = RequestMethod.POST)
	public FilmDTO createFilm(@RequestBody FilmDTO film) {
	return filmService.saveFilm(film);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public FilmDTO updateFilm(@RequestBody FilmDTO film) {
	return filmService.updateFilm(film);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteFilm(@PathVariable("id") Long id)
	{
	filmService.deleteFilmById(id);
	}
	@RequestMapping(value="/filmgenre/{idGenre}",method = RequestMethod.GET)
	public List<Film> getFilmByGenreIdGenre(@PathVariable("idGenre") Long idGenre) {
	return filmService.findByGenreIdGenre(idGenre);
	}
	@RequestMapping(value="/FilmByName/{nom}",method = RequestMethod.GET)
	public List<Film> findByNomFilmContains(@PathVariable("nom") String nom) {
	return filmService.findByNomFilmContains(nom);
	}




}
