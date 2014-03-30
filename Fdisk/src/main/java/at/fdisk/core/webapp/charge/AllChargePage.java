package at.fdisk.core.webapp.charge;

import org.apache.wicket.Component;

import at.fdisk.core.webapp.FdiskManagementPage;

public class AllChargePage extends FdiskManagementPage {

	protected Component contentPanel() {
		return new AllChargePanel("AllChargePanel");
	}
}
