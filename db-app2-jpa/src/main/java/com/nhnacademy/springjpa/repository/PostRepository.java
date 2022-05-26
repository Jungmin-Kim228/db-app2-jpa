package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.domain.PostDto;
import com.nhnacademy.springjpa.entity.Post;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    // test purpose
    int countByPostTitleLike(String postTitle);

    List<PostDto> getAllBy();

    PostDto getByPostNo(Integer postNo);
}
