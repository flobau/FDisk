package at.fdisk.core.webapp.ausruestung;

import org.apache.wicket.Component;

import at.fdisk.core.webapp.FdiskManagementPage;

public class AllAusruestungPage extends FdiskManagementPage {

	protected Component contentPanel() {
		return new AllAusruestungPanel("AllAusruestungPanel");
	}
}
