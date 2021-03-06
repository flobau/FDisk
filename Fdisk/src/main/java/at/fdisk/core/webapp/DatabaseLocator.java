package at.fdisk.core.webapp;

import org.apache.wicket.Application;

import at.fdisk.core.webapp.ausbildung.AusbildungDB;
import at.fdisk.core.webapp.ausruestung.AusruestungDB;
import at.fdisk.core.webapp.feuerwehrauto.FeuerwehrautoDB;
import at.fdisk.core.webapp.geraet.GeraetDB;
import at.fdisk.core.webapp.mitglied.MitgliedDB;

public class DatabaseLocator
{
	/**
	 * @return contacts database
	 */
	public static AusbildungDB getAusbildungDatabase()
	{
		FdiskManagementApplication app = (FdiskManagementApplication)Application.get();
		return app.getAusbildungDB();
	}
	
	public static AusruestungDB getAusruestungDatabase()
	{
		FdiskManagementApplication app = (FdiskManagementApplication)Application.get();
		return app.getAusruestungDB();
	}
	
	public static FeuerwehrautoDB getFeuerwehrautoDatabase(){
		FdiskManagementApplication app = (FdiskManagementApplication)Application.get();
		return app.getFeuerwehrautoDB();
	}
	
	public static GeraetDB getGeraetDatabase(){
		FdiskManagementApplication app = (FdiskManagementApplication)Application.get();
		return app.getGeraetDB();
	}
	
	public static MitgliedDB getMitgliedDatabase(){
		FdiskManagementApplication app = (FdiskManagementApplication)Application.get();
		return app.getMitgliedDB();
	}
}