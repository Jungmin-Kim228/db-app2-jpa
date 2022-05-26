package com.nhnacademy.springjpa.controller;

import com.nhnacademy.springjpa.domain.post.PostDto;
import com.nhnacademy.springjpa.service.PostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private PostService postService;

    public PostsController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostDto> getPosts(Pageable pageable) {
        return postService.getPosts(pageable).getContent();
    }
}
