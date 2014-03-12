package at.fdisk.core.webapp;

import org.apache.wicket.markup.html.panel.Panel;
import at.fdisk.core.webapp.ausbildung.AusbildungPage;
import org.apache.wicket.markup.html.link.Link;

public class NavigationPanel extends Panel {
	public NavigationPanel(String id) {
		super(id);
		add(new Link("navigateAusbildung") {
			@Override
			public void onClick() {
				setResponsePage(AusbildungPage.class);
			}
		});
	}
}