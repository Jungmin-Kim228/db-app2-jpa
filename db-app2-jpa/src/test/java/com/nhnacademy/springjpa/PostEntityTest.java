package com.nhnacademy.springjpa;

import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import com.nhnacademy.springjpa.entity.Post;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
    @PersistenceContext
    EntityManager entityManager;

    @Test
    void test() {
        Post post = entityManager.find(Post.class, 1);
        assertThat(post.getPostNo().intValue()).isEqualTo(1);
    }

    @Test
    void postRegisterAndSelectTest() {
        Post post1 = new Post();
        post1.setPostNo(1);
        post1.setUserNo(1);
        post1.setPostTitle("title1");
        post1.setPostContent("content1");
        post1.setPostWriteDateTime(new Date());
        post1.setPostCheckHide(false);
        post1.setParent(0);
        post1.setDepth(0);
        post1.setFileName("fileName");

        entityManager.persist(post1);
//        entityManager.flush();

        Post post2 = entityManager.find(Post.class, 1);
        assertThat(post2).isEqualTo(post1);

    }
}
