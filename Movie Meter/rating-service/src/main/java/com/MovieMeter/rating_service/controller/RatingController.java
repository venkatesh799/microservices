package com.MovieMeter.rating_service.controller;

import com.MovieMeter.rating_service.model.Rating;
import com.MovieMeter.rating_service.model.RatingDTO;
import com.MovieMeter.rating_service.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @GetMapping("/{id}")
    public ResponseEntity<RatingDTO> getRating(@PathVariable Integer id) {
        return ratingService.getRating(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Integer> addRating(@RequestBody Rating rating) {
        return ratingService.addRating(rating);
    }
}
