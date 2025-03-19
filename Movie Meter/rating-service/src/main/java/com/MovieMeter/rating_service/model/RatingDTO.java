package com.MovieMeter.rating_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingDTO {
    private Integer movieID;
    private String movieName;
    private String description;
    private float rating;
    private Integer totalRatings;
    private List<Map<String, Object>> reviews;
}
