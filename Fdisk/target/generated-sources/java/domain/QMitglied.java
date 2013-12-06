package domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QMitglied is a Querydsl query type for Mitglied
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QMitglied extends EntityPathBase<Mitglied> {

    private static final long serialVersionUID = -342207883;

    public static final QMitglied mitglied = new QMitglied("mitglied");

    public final QBasePersistable _super = new QBasePersistable(this);

    public final CollectionPath<Ausbildung, QAusbildung> ausbildung = this.<Ausbildung, QAusbildung>createCollection("ausbildung", Ausbildung.class, QAusbildung.class, PathInits.DIRECT2);

    public final CollectionPath<Ausruestung, QAusruestung> ausruestungen = this.<Ausruestung, QAusruestung>createCollection("ausruestungen", Ausruestung.class, QAusruestung.class, PathInits.DIRECT2);

    public final StringPath dienstgrad = createString("dienstgrad");

    public final DatePath<java.util.Date> geburtsdatum = createDate("geburtsdatum", java.util.Date.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath nachname = createString("nachname");

    public final StringPath vorname = createString("vorname");

    public final StringPath wohnort = createString("wohnort");

    public QMitglied(String variable) {
        super(Mitglied.class, forVariable(variable));
    }

    public QMitglied(Path<? extends Mitglied> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMitglied(PathMetadata<?> metadata) {
        super(Mitglied.class, metadata);
    }

}

