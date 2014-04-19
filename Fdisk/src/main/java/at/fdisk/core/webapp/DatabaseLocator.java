package at.fdisk.core.webapp;

import org.apache.wicket.Application;

import at.fdisk.core.webapp.ausbildung.AusbildungDB;
import at.fdisk.core.webapp.ausruestung.AusruestungDB;

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
}