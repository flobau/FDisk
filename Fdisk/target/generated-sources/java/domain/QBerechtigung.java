package domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QBerechtigung is a Querydsl query type for Berechtigung
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBerechtigung extends EntityPathBase<Berechtigung> {

    private static final long serialVersionUID = -1652533119;

    public static final QBerechtigung berechtigung1 = new QBerechtigung("berechtigung1");

    public final QBasePersistable _super = new QBasePersistable(this);

    public final CollectionPath<User, QUser> berechtigte = this.<User, QUser>createCollection("berechtigte", User.class, QUser.class, PathInits.DIRECT2);

    public final StringPath berechtigung = createString("berechtigung");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public QBerechtigung(String variable) {
        super(Berechtigung.class, forVariable(variable));
    }

    public QBerechtigung(Path<? extends Berechtigung> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBerechtigung(PathMetadata<?> metadata) {
        super(Berechtigung.class, metadata);
    }

}

