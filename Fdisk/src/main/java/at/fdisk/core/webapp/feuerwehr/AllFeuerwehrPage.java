package at.fdisk.core.webapp.feuerwehr;

import org.apache.wicket.Component;

import at.fdisk.core.webapp.FdiskManagementPage;

public class AllFeuerwehrPage extends FdiskManagementPage {

	protected Component contentPanel() {
		return new AllFeuerwehrPanel("AllFeuerwehrPanel");
	}
}
