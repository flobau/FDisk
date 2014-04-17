package at.fdisk.core.webapp.ausbildung;

import org.apache.wicket.Application;

import at.fdisk.core.webapp.FdiskManagementApplication;

public class DatabaseLocator
{
	/**
	 * @return contacts database
	 */
	public static AusbildungDB getDatabase()
	{
		FdiskManagementApplication app = (FdiskManagementApplication)Application.get();
		return app.getAusbildungDB();
	}
}