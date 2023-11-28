package com.rayen.Film.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rayen.Film.entities.Image;

public interface ImageRepository extends JpaRepository<Image , Long> {
}
