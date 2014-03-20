package at.fdisk.core.webapp.charge;

import at.fdisk.core.webapp.ContentPanel;

public class ChargePanel extends ContentPanel {
	public ChargePanel(String id) {
		super(id);
		add(new ChargeForm("chargeForm"));
	}
}
