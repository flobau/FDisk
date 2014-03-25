package at.fdisk.core.webapp.feuerwehr;

import at.fdisk.core.webapp.ContentPanel;

public class FeuerwehrPanel extends ContentPanel {
	public FeuerwehrPanel(String id) {
		super(id);
		add(new FeuerwehrForm("feuerwehrForm"));
	}
}
