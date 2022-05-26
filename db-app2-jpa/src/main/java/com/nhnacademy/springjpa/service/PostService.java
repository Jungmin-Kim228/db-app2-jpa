package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.PostDto;
import com.nhnacademy.springjpa.domain.PostRegisterRequest;
import com.nhnacademy.springjpa.entity.Post;
import com.nhnacademy.springjpa.entity.User;

public interface PostService {
    PostDto getPost(Integer no);

    PostDto createPost(PostRegisterRequest postRequest);

    Post modifyPost(Post post);

    void deletePost(Integer postNo);
}
