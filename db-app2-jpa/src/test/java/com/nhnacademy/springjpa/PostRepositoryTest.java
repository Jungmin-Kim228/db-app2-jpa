package com.nhnacademy.springjpa;

import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import com.nhnacademy.springjpa.entity.Post;
import com.nhnacademy.springjpa.repository.PostRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
    @ContextConfiguration(classes = RootConfig.class),
    @ContextConfiguration(classes = WebConfig.class)
})
public class PostRepositoryTest {
    @Autowired
    private PostRepository postRepository;

    @Test
    void findAllTest() {
        List<Post> posts = postRepository.findAll();
        assertThat(posts.size()).isEqualTo(5);
    }

    @Test
    void postCountTest() {
        int postCount = postRepository.countByPostTitleLike("this%");
        assertThat(postCount).isEqualTo(2);
    }

//    @Test
//    void postDtoGetAllByTest() {
//        List<PostDto> postDtos = postRepository.getAllBy();
//        assertThat(postDtos.get(0).getComments().get(0).getCommentContent()).isEqualTo("ㅇㅈ");
//    }


}
