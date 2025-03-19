package com.MovieMeter.user_service.dao;

import com.MovieMeter.user_service.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<Users, Integer> {
}
