package at.fdisk.core.webapp.mitglied;

import at.fdisk.core.webapp.ContentPanel;

public class NewMitgliedPanel extends ContentPanel{
	
	public NewMitgliedPanel(String id) {
		super(id);
		add(new NewMitgliedForm("newGeraetForm"));
	}
}
