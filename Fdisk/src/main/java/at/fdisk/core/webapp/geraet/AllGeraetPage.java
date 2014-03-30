package at.fdisk.core.webapp.geraet;

import org.apache.wicket.Component;

import at.fdisk.core.webapp.FdiskManagementPage;

public class AllGeraetPage extends FdiskManagementPage {

	protected Component contentPanel() {
		return new AllGeraetPanel("AllGeraetPanel");
	}
}
