package com.moviemeter.movie_service.service;

import com.moviemeter.movie_service.dao.MovieDao;
import com.moviemeter.movie_service.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieDao movieDao;

    public ResponseEntity<Movie> getMovieDetails(Integer id) {
        Movie movie = movieDao.findById(id).orElse(null); // Assuming you're using Optional and want to handle null cases
        if (movie != null) {
            return new ResponseEntity<>(movie, HttpStatus.OK); // Return movie details
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // If movie not found
        }
    }

    public ResponseEntity<Integer> addMovie(Movie movie) {
        try {
            movieDao.save(movie);
            return new ResponseEntity<>(movie.getMovieID(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public boolean checkMovieExists(Integer movieID) {
        return movieDao.existsById(movieID);
    }

    public ResponseEntity<List<Movie>> getAllMovies() {
        try {
            return new ResponseEntity<>(movieDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }
    }
}
