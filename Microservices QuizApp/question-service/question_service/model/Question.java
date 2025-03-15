package com.venkatesh.question_service.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;

    // the below statement says that this is the exact column name
    // as difficulty_level in database
    @Column(name = "difficulty_level", nullable = false)
    private String difficultylevel;
    private String category;

}
