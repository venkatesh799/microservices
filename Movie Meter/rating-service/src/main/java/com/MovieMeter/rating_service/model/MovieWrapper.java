package com.MovieMeter.rating_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieWrapper {

    private int movieID;

    private String movieName;

    private String description;
}
