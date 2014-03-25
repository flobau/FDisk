package at.fdisk.core.webapp.feuerwehrauto;

import at.fdisk.core.webapp.ContentPanel;

public class FeuerwehrautoPanel extends ContentPanel {
	public FeuerwehrautoPanel(String id) {
		super(id);
		add(new FeuerwehrautoForm("feuerwehrautoForm"));
	}
}
