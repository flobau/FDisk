package at.fdisk.core.webapp.ausruestung;

import at.fdisk.core.webapp.ContentPanel;

public class AusruestungPanel extends ContentPanel {
	public AusruestungPanel(String id) {
		super(id);
		add(new AusruestungForm("ausruestungForm"));
	}
}
