package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserByUserNo(Integer no);
}
