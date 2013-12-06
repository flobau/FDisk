package domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QFeuerwehr is a Querydsl query type for Feuerwehr
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QFeuerwehr extends EntityPathBase<Feuerwehr> {

    private static final long serialVersionUID = 203666641;

    public static final QFeuerwehr feuerwehr = new QFeuerwehr("feuerwehr");

    public final QBasePersistable _super = new QBasePersistable(this);

    public final CollectionPath<Ausbildung, QAusbildung> ausbildungen = this.<Ausbildung, QAusbildung>createCollection("ausbildungen", Ausbildung.class, QAusbildung.class, PathInits.DIRECT2);

    public final CollectionPath<Feuerwehrauto, QFeuerwehrauto> autos = this.<Feuerwehrauto, QFeuerwehrauto>createCollection("autos", Feuerwehrauto.class, QFeuerwehrauto.class, PathInits.DIRECT2);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath ort = createString("ort");

    public QFeuerwehr(String variable) {
        super(Feuerwehr.class, forVariable(variable));
    }

    public QFeuerwehr(Path<? extends Feuerwehr> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFeuerwehr(PathMetadata<?> metadata) {
        super(Feuerwehr.class, metadata);
    }

}

