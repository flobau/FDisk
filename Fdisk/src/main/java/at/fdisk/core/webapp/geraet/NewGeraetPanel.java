package at.fdisk.core.webapp.geraet;

import at.fdisk.core.webapp.ContentPanel;

public class NewGeraetPanel extends ContentPanel{
	
	public NewGeraetPanel(String id) {
		super(id);
		add(new NewGeraetForm("newGeraetForm"));
	}
}
