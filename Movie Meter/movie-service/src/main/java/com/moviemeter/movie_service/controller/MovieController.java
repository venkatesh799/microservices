package com.moviemeter.movie_service.controller;

import com.moviemeter.movie_service.model.Movie;
import com.moviemeter.movie_service.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieDetails(@PathVariable Integer id) {
        return movieService.getMovieDetails(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Integer> addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @GetMapping("/exists/{movieID}")
    public boolean checkMovieExists(@PathVariable Integer movieID) {
        return movieService.checkMovieExists(movieID);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return movieService.getAllMovies();
    }
}
