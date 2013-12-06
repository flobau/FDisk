package domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QCharge is a Querydsl query type for Charge
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCharge extends EntityPathBase<Charge> {

    private static final long serialVersionUID = -489243842;

    public static final QCharge charge = new QCharge("charge");

    public final QMitglied _super = new QMitglied(this);

    //inherited
    public final CollectionPath<Ausbildung, QAusbildung> ausbildung = _super.ausbildung;

    //inherited
    public final CollectionPath<Ausruestung, QAusruestung> ausruestungen = _super.ausruestungen;

    //inherited
    public final StringPath dienstgrad = _super.dienstgrad;

    public final StringPath fachgebiet = createString("fachgebiet");

    //inherited
    public final DatePath<java.util.Date> geburtsdatum = _super.geburtsdatum;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final StringPath nachname = _super.nachname;

    //inherited
    public final StringPath vorname = _super.vorname;

    //inherited
    public final StringPath wohnort = _super.wohnort;

    public QCharge(String variable) {
        super(Charge.class, forVariable(variable));
    }

    public QCharge(Path<? extends Charge> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCharge(PathMetadata<?> metadata) {
        super(Charge.class, metadata);
    }

}

