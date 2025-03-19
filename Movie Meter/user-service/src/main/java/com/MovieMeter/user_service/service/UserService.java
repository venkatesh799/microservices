package com.MovieMeter.user_service.service;

import com.MovieMeter.user_service.dao.UserDao;
import com.MovieMeter.user_service.model.UserWrapper;
import com.MovieMeter.user_service.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public ResponseEntity<Users> getUser(Integer id) {
        Users user = userDao.findById(id).orElse(null);
        if(user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Integer> addUser(Users users) {
        try {
            userDao.save(users);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
