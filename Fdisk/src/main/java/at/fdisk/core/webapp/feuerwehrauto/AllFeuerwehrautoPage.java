package at.fdisk.core.webapp.feuerwehrauto;

import org.apache.wicket.Component;

import at.fdisk.core.webapp.FdiskManagementPage;

public class AllFeuerwehrautoPage extends FdiskManagementPage {

	protected Component contentPanel() {
		return new AllFeuerwehrautoPanel("AllFeuerwehrautoPanel");
	}
}
