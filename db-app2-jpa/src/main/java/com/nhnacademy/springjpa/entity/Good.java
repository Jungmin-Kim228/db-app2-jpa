package com.nhnacademy.springjpa.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Goods")
public class Good {
    @EmbeddedId
    private Pk pk;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "good_no")
    private Integer goodNo;

    @MapsId("postNo")
    @ManyToOne
    @JoinColumn(name = "post_no")
    private Post post;

    @Column(name = "user_no")
    private Integer userNo;

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    @Setter
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "good_no")
        private Integer goodNo;

        @Column(name = "post_no")
        private Integer postNo;
    }
}
