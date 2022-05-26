package com.nhnacademy.springjpa;

import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import com.nhnacademy.springjpa.entity.Post;
import com.nhnacademy.springjpa.entity.User;
import com.nhnacademy.springjpa.repository.CommentRepository;
import com.nhnacademy.springjpa.repository.PostRepository;
import com.nhnacademy.springjpa.repository.UserRepository;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

//@Disabled("temporary")
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
    @ContextConfiguration(classes = RootConfig.class),
    @ContextConfiguration(classes = WebConfig.class)
})
public class PostEntityTest {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void test() {
        User user1 = new User();
        user1.setUserId("user1Id");
        user1.setUserPw("user1Pw");
        user1.setCheckAdmin(false);

        Post post1 = new Post();
        post1.setUser(user1);
        post1.setPostTitle("post1Title");
        post1.setPostContent("post1Content");
        post1.setPostWriteDateTime(LocalDateTime.now());
        post1.setPostCheckHide(false);
        post1.setParent(0);
        post1.setDepth(0);

        Post post2 = new Post();
        post2.setUser(user1);
        post2.setPostTitle("post2Title");
        post2.setPostContent("post2Content");
        post2.setPostWriteDateTime(LocalDateTime.now());
        post2.setPostCheckHide(false);
        post2.setParent(0);
        post2.setDepth(0);

        userRepository.save(user1);
        postRepository.saveAll(Arrays.asList(post1, post2));
        assertThat(post2.getUser().getUserId()).isEqualTo("user1Id");
        postRepository.flush();
    }

}
