package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    int countByPostTitleLike(String postTitle);
    // select count(*) from Posts where post_title like '%{postTitle}'

}
