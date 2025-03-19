package com.MovieMeter.rating_service.feign;

import com.MovieMeter.rating_service.model.MovieWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("MOVIE-SERVICE")
public interface RatingInterface {

    @GetMapping("movies/exists/{movieID}")
    public boolean checkMovieExists(@PathVariable("movieID")  Integer movieID);

    @GetMapping("movies/{id}")
    public ResponseEntity<MovieWrapper> getMovieDetails(@PathVariable Integer id);

}

