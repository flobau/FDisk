package at.fdisk.core.webapp.ausbildung;

import at.fdisk.core.webapp.ContentPanel;

public class AusbildungPanel extends ContentPanel {
	public AusbildungPanel(String id) {
		super(id);
		add(new AusbildungForm("ausbildungForm"));
	}
}
