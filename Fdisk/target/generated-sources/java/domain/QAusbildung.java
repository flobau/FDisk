package domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QAusbildung is a Querydsl query type for Ausbildung
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAusbildung extends EntityPathBase<Ausbildung> {

    private static final long serialVersionUID = 2025762938;

    public static final QAusbildung ausbildung = new QAusbildung("ausbildung");

    public final QBasePersistable _super = new QBasePersistable(this);

    public final StringPath bezeichnung = createString("bezeichnung");

    public final DatePath<java.util.Date> enddatum = createDate("enddatum", java.util.Date.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath kurzBezeichnung = createString("kurzBezeichnung");

    public final DatePath<java.util.Date> startdatum = createDate("startdatum", java.util.Date.class);

    public QAusbildung(String variable) {
        super(Ausbildung.class, forVariable(variable));
    }

    public QAusbildung(Path<? extends Ausbildung> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAusbildung(PathMetadata<?> metadata) {
        super(Ausbildung.class, metadata);
    }

}

