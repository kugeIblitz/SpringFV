package com.rayen.Film.repos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rayen.Film.entities.Film;
import com.rayen.Film.entities.Genre;

@RepositoryRestResource(path = "rest")
public interface FilmRepository extends JpaRepository<Film, Long> {
	List<Film> findByNomFilm(String nom);
	 List<Film> findByNomFilmContains(String nom); 
	 @Query("select f from Film f where f.nomFilm like %?1 and f.descriptionFilm like %?1 ")
	 List<Film> findByNomdescription(@Param("nom") String nom,@Param("description") String description);
	 @Query("select f from Film f where f.genre = ?1")
	 List<Film> findByGenre(Genre genre);
	 List<Film> findByGenreIdGenre(Long id);
	 List<Film> findByOrderByNomFilmAsc();
	 @Query("select f from Film f order by f.nomFilm ASC, f.descriptionFilm DESC")
	 List<Film> trierFilmNomsdescription();


}
