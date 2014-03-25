package at.fdisk.core.webapp.mitglied;

import at.fdisk.core.webapp.ContentPanel;

public class MitgliedPanel extends ContentPanel {
	public MitgliedPanel(String id) {
		super(id);
		add(new MitgliedForm("mitgliedForm"));
	}
}
