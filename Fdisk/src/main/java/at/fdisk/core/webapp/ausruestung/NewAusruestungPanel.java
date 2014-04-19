package at.fdisk.core.webapp.ausruestung;

import at.fdisk.core.webapp.ContentPanel;

public class NewAusruestungPanel extends ContentPanel {

	public NewAusruestungPanel(String id) {
		super(id);

		add(new NewAusruestungForm("newAusruestungForm"));
	}

}
