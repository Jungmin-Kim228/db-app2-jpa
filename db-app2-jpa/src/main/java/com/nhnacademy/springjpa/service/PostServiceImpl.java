package com.nhnacademy.springjpa.service;

import com.nhnacademy.springjpa.domain.PostDto;
import com.nhnacademy.springjpa.domain.PostRegisterRequest;
import com.nhnacademy.springjpa.entity.Post;
import com.nhnacademy.springjpa.entity.User;
import com.nhnacademy.springjpa.repository.PostRepository;
import com.nhnacademy.springjpa.repository.UserRepository;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public PostDto getPost(Integer no) {
        return postRepository.getByPostNo(no);
    }

    @Transactional
    @Override
    public PostDto createPost(PostRegisterRequest postRequest) {
        User user = userRepository.getUserByUserNo(postRequest.getUserNo());
        Post post = Post.addPost()
            .user(user)
            .postTitle(postRequest.getPostTitle())
            .postContent(postRequest.getPostContent())
            .fileName(postRequest.getFileName())
            .fileData(postRequest.getFileData())
            .build();
        postRepository.save(post);

        PostDto postDto = postRepository.getByPostNo(post.getPostNo());
        return postDto;
    }

    @Override
    public Post modifyPost(Post post) {
        return null;
    }

    @Override
    public void deletePost(Integer postNo) {

    }
}
