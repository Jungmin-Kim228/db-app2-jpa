package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.post.PostDto;
import com.nhnacademy.springjpa.domain.post.PostModifyDto;
import com.nhnacademy.springjpa.domain.post.PostRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    PostDto getPost(Integer no);

    Page<PostDto> getPosts(Pageable pageable);

    PostDto createPost(PostRequest postRequest);

    PostModifyDto modifyPost(Integer postNo, PostRequest postRequest);

    Integer deletePost(Integer postNo);
}
