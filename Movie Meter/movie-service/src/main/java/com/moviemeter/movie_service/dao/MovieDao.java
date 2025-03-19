package com.moviemeter.movie_service.dao;

import com.moviemeter.movie_service.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDao extends JpaRepository<Movie, Integer> {
}
