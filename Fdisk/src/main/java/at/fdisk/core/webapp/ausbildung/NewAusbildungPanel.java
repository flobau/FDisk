package at.fdisk.core.webapp.ausbildung;

import at.fdisk.core.webapp.ContentPanel;

public class NewAusbildungPanel extends ContentPanel {

	public NewAusbildungPanel(String id) {
		super(id);

		add(new NewAusbildungForm("newAusbildungForm"));
	}

}
