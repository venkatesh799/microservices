package com.venkatesh.quiz_service.controller;
import com.venkatesh.quiz_service.model.QuestionWrapper;
import com.venkatesh.quiz_service.model.QuizDto;
import com.venkatesh.quiz_service.model.Response;
import com.venkatesh.quiz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto ) {

        return quizService.createQuiz(quizDto.getCategory(),
                quizDto.getNumQ(),
                quizDto.getTitle());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id) {
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitquiz(@PathVariable Integer id,
                                              @RequestBody List<Response> responses) {
        return quizService.calculateResponse(id, responses);
    }
}
