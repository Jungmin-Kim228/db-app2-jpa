package com.nhnacademy.springjpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="comment_no")
    private Integer commentNo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "post_no")
    private Post post;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_no")
    private User user;

    @Column(name = "comment_content")
    private String commentContent;
}
