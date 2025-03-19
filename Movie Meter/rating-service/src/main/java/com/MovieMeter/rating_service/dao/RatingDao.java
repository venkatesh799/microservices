package com.MovieMeter.rating_service.dao;

import com.MovieMeter.rating_service.model.Rating;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingDao extends JpaRepository<Rating, Integer> {

    @Query(value = "SELECT AVG(rating) FROM rating WHERE movieid= :id", nativeQuery=true)
    Double findAverageRating(Integer id);

    Integer countByMovieID(Integer movieID);

    @Query(value = "SELECT userID, rating FROM rating WHERE movieid= :id", nativeQuery = true)
    List<Object[]> getReviews(Integer id);
}
