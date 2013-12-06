package domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QAusruestung is a Querydsl query type for Ausruestung
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAusruestung extends EntityPathBase<Ausruestung> {

    private static final long serialVersionUID = -1932128480;

    public static final QAusruestung ausruestung = new QAusruestung("ausruestung");

    public final QBasePersistable _super = new QBasePersistable(this);

    public final DatePath<java.util.Date> ausgegeben = createDate("ausgegeben", java.util.Date.class);

    public final StringPath bezeichnung = createString("bezeichnung");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public QAusruestung(String variable) {
        super(Ausruestung.class, forVariable(variable));
    }

    public QAusruestung(Path<? extends Ausruestung> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAusruestung(PathMetadata<?> metadata) {
        super(Ausruestung.class, metadata);
    }

}

