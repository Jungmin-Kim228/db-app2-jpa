package com.nhnacademy.springjpa.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGood is a Querydsl query type for Good
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QGood extends EntityPathBase<Good> {

    private static final long serialVersionUID = 404215967L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGood good = new QGood("good");

    public final NumberPath<Integer> goodNo = createNumber("goodNo", Integer.class);

    public final QPost post;

    public final QUser user;

    public QGood(String variable) {
        this(Good.class, forVariable(variable), INITS);
    }

    public QGood(Path<? extends Good> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGood(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGood(PathMetadata metadata, PathInits inits) {
        this(Good.class, metadata, inits);
    }

    public QGood(Class<? extends Good> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.post = inits.isInitialized("post") ? new QPost(forProperty("post"), inits.get("post")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

