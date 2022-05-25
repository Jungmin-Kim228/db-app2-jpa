package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Good;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodRepository extends JpaRepository<Good, Integer> {
}
