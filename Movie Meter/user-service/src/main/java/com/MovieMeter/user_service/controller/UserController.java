package com.MovieMeter.user_service.controller;
import com.MovieMeter.user_service.model.UserWrapper;
import com.MovieMeter.user_service.model.Users;
import com.MovieMeter.user_service.service.UserService;
import org.apache.catalina.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Integer> addUser(@RequestBody Users users) {
        return userService.addUser(users);
    }

    @GetMapping("/ratings/{id}")
    public ResponseEntity<UserWrapper> getReviews(@PathVariable Integer id) {
        return userService.getReviews(id);
    }
}
