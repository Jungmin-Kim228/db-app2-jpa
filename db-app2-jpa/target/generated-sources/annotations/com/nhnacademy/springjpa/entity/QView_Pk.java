package com.nhnacademy.springjpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QView_Pk is a Querydsl query type for Pk
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QView_Pk extends BeanPath<View.Pk> {

    private static final long serialVersionUID = -843169054L;

    public static final QView_Pk pk = new QView_Pk("pk");

    public final NumberPath<Integer> postNo = createNumber("postNo", Integer.class);

    public final NumberPath<Integer> userNo = createNumber("userNo", Integer.class);

    public QView_Pk(String variable) {
        super(View.Pk.class, forVariable(variable));
    }

    public QView_Pk(Path<? extends View.Pk> path) {
        super(path.getType(), path.getMetadata());
    }

    public QView_Pk(PathMetadata metadata) {
        super(View.Pk.class, metadata);
    }

}

