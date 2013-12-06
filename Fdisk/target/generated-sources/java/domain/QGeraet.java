package domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QGeraet is a Querydsl query type for Geraet
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QGeraet extends EntityPathBase<Geraet> {

    private static final long serialVersionUID = -377007738;

    public static final QGeraet geraet = new QGeraet("geraet");

    public final QBasePersistable _super = new QBasePersistable(this);

    public final StringPath bezeichnung = createString("bezeichnung");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final DatePath<java.util.Date> pruefungstermin = createDate("pruefungstermin", java.util.Date.class);

    public QGeraet(String variable) {
        super(Geraet.class, forVariable(variable));
    }

    public QGeraet(Path<? extends Geraet> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGeraet(PathMetadata<?> metadata) {
        super(Geraet.class, metadata);
    }

}

