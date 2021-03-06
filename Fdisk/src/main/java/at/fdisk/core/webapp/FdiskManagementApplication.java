package at.fdisk.core.webapp;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import at.fdisk.core.webapp.ausbildung.AusbildungDB;
import at.fdisk.core.webapp.ausruestung.AusruestungDB;
import at.fdisk.core.webapp.feuerwehrauto.FeuerwehrautoDB;
import at.fdisk.core.webapp.geraet.GeraetDB;
import at.fdisk.core.webapp.mitglied.MitgliedDB;

/**
 *
 */
public class FdiskManagementApplication extends WebApplication {

	private final AusbildungDB ausbildungDB = new AusbildungDB();
	private final AusruestungDB ausruestungDB = new AusruestungDB();
	private final FeuerwehrautoDB feuerwehrautoDB = new FeuerwehrautoDB();
	private final GeraetDB geraetDB = new GeraetDB();
	private final MitgliedDB mitgliedDB = new MitgliedDB();

	@Override
	public Class<? extends Page> getHomePage() {
		return FdiskManagementPage.class;
	}

	@Override
	public void init() {
		super.init();

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		// Scan package for annotated beans
		ctx.scan("at.fdisk.core.webapp");
		ctx.refresh();

		getComponentInstantiationListeners().add(
				new SpringComponentInjector(this, ctx));
	}

	public AusbildungDB getAusbildungDB() {
		return ausbildungDB;
	}

	public AusruestungDB getAusruestungDB() {
		return ausruestungDB;
	}

	public FeuerwehrautoDB getFeuerwehrautoDB() {
		return feuerwehrautoDB;
	}

	public GeraetDB getGeraetDB() {
		return geraetDB;
	}
	
	public MitgliedDB getMitgliedDB() {
		return mitgliedDB;
	}
}
