package com.rayen.Film.dto;

import java.util.Date;

import com.rayen.Film.entities.Genre;
import com.rayen.Film.entities.Image;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class FilmDTO {
    private Long idFilm;
    private String nomFilm;
    private String descriptionFilm;
    private Date dateCreation;
    private Genre genre;
    private Image image;

}
