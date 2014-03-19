package at.fdisk.core.webapp;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class InfoPage extends WebPage {
	public InfoPage() {
		super();
		add(new Label("info", "Info"));
	}
}