package at.fdisk.core.webapp.feuerwehrauto;

import at.fdisk.core.webapp.ContentPanel;

public class NewFeuerwehrautoPanel extends ContentPanel{
	
	public NewFeuerwehrautoPanel(String id) {
		super(id);
		add(new NewFeuerwehrautoForm("newFeuerwehrautoForm"));
	}
}
