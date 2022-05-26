package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.post.PostDto;
import com.nhnacademy.springjpa.domain.post.PostModifyDto;
import com.nhnacademy.springjpa.domain.post.PostModifyRequest;
import com.nhnacademy.springjpa.domain.post.PostRegisterRequest;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    PostDto getPost(Integer no);

    Page<PostDto> getPosts(Pageable pageable);

    PostDto createPost(PostRegisterRequest postRequest);

    PostModifyDto modifyPost(Integer postNo, PostModifyRequest postRequest);

    Integer deletePost(Integer postNo);
}
