package at.fdisk.core.webapp;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.basic.Label;
import java.util.Date;

public class HeaderPanel extends Panel {
	public HeaderPanel(String id) {
		super(id);
		add(new Label("now", new Date().toString()));
	}
}