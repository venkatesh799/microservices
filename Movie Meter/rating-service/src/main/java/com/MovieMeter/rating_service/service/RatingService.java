package com.MovieMeter.rating_service.service;

import com.MovieMeter.rating_service.dao.RatingDao;
import com.MovieMeter.rating_service.feign.RatingInterface;
import com.MovieMeter.rating_service.model.MovieWrapper;
import com.MovieMeter.rating_service.model.Rating;
import com.MovieMeter.rating_service.model.RatingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RatingService {

    @Autowired
    RatingInterface ratingInterface;

    @Autowired
    RatingDao ratingDao;

    public ResponseEntity<Integer> addRating(Rating rating) {
        if(rating.getMovieID() != null && ratingInterface.checkMovieExists(rating.getMovieID())) {
            try {
                ratingDao.save(rating);
                return new ResponseEntity<>(rating.getMovieID(), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<RatingDTO> getRating(Integer id) {

        // This is the final response that returned to user
        RatingDTO ratingDTO = new RatingDTO();

        // Response we will get from Movies service
        MovieWrapper movieWrapper = ratingInterface.getMovieDetails(id).getBody();

        // Response we will get from Rating
        Rating rating = ratingDao.findById(id).orElse(null); // Assuming you're using Optional and want to handle null cases

        // here below we need to merge both responses from Movie Service and rating to the
        // User Response

        ratingDTO.setDescription(movieWrapper.getDescription());
        ratingDTO.setMovieName(movieWrapper.getMovieName());
        ratingDTO.setMovieID(movieWrapper.getMovieID());
        // Finding Average Rating for movie
        Double avgRating = ratingDao.findAverageRating(id);
        ratingDTO.setRating(avgRating.floatValue());
        // finding total review
        ratingDTO.setTotalRatings(ratingDao.countByMovieID(rating.getMovieID()));

        // Retrieving all individual review for a movie like userID, rating
        List<Object[]> rows = ratingDao.getReviews(rating.getMovieID());

        List<Map<String, Object>> reviews = new ArrayList<>();
        for(Object[] row: rows) {
            Map<String, Object> review = new HashMap<>();
            review.put("userId", row[0]);
            review.put("rating", row[1]);
            reviews.add(review);
        }
        ratingDTO.setReviews(reviews);
        // Returning final response
        return new ResponseEntity<>(ratingDTO, HttpStatus.OK); // Return movie details
    }
}
