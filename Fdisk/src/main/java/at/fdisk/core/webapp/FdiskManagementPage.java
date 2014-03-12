package at.fdisk.core.webapp;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class FdiskManagementPage extends WebPage {
	private Component headerPanel;
	private Component navigationPanel;
	private Component contentPanel;
	private Component footerPanel;

	public FdiskManagementPage() {
		add(new Label("helloMessage", "Hello WicketWorld!"));
		add(headerPanel = new HeaderPanel("headerPanel"));
		add(navigationPanel = new NavigationPanel("navigationPanel"));
		contentPanel = contentPanel();
		if (contentPanel != null) {
			add(contentPanel);
		}
		add(footerPanel = new FooterPanel("footerPanel"));
	}

	protected Component contentPanel() {
		return null;
	}
}
