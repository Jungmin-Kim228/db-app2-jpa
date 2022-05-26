package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.domain.post.PostDto;
import com.nhnacademy.springjpa.domain.post.PostModifyDto;
import com.nhnacademy.springjpa.entity.Post;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    // test purpose
    int countByPostTitleLike(String postTitle);

    Page<PostDto> getPostDtosAllBy(Pageable pageable);

    PostDto getPostDtoByPostNo(Integer postNo);

    PostModifyDto getPostModifyDtoByPostNo(Integer postNo);

    Post getPostByPostNo(Integer postNo);

}
