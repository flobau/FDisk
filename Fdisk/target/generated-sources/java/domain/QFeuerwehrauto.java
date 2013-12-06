package domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QFeuerwehrauto is a Querydsl query type for Feuerwehrauto
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QFeuerwehrauto extends EntityPathBase<Feuerwehrauto> {

    private static final long serialVersionUID = 920175104;

    public static final QFeuerwehrauto feuerwehrauto = new QFeuerwehrauto("feuerwehrauto");

    public final QBasePersistable _super = new QBasePersistable(this);

    public final CollectionPath<Geraet, QGeraet> geraete = this.<Geraet, QGeraet>createCollection("geraete", Geraet.class, QGeraet.class, PathInits.DIRECT2);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Integer> sitzplaetze = createNumber("sitzplaetze", Integer.class);

    public final StringPath typ = createString("typ");

    public QFeuerwehrauto(String variable) {
        super(Feuerwehrauto.class, forVariable(variable));
    }

    public QFeuerwehrauto(Path<? extends Feuerwehrauto> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFeuerwehrauto(PathMetadata<?> metadata) {
        super(Feuerwehrauto.class, metadata);
    }

}

