package at.fdisk.core.webapp.geraet;

import at.fdisk.core.webapp.ContentPanel;

public class GeraetPanel extends ContentPanel {
	public GeraetPanel(String id) {
		super(id);
		add(new GeraetForm("geraetForm"));
	}
}
