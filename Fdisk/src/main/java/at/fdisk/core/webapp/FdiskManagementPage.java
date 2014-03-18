package at.fdisk.core.webapp;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FdiskManagementPage extends WebPage {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	private Component headerPanel;
	private Component navigationPanel;
	private Component contentPanel;
	private Component footerPanel;

	public FdiskManagementPage() {
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
