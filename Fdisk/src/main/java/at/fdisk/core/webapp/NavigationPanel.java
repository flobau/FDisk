package at.fdisk.core.webapp;

import org.apache.wicket.markup.html.panel.Panel;

import at.fdisk.core.webapp.ausbildung.AusbildungPage;
import at.fdisk.core.webapp.ausruestung.AusruestungPage;
import at.fdisk.core.webapp.charge.ChargePage;
import at.fdisk.core.webapp.feuerwehr.FeuerwehrPage;
import at.fdisk.core.webapp.feuerwehrauto.FeuerwehrautoPage;
import at.fdisk.core.webapp.geraet.GeraetPage;

import org.apache.wicket.markup.html.link.Link;

public class NavigationPanel extends Panel {
	public NavigationPanel(String id) {
		super(id);
		add(new Link("navigateInfo") {
			@Override
			public void onClick() {
				setResponsePage(InfoPage.class);
			}
		});
		add(new Link("navigateAusbildung") {
			@Override
			public void onClick() {
				setResponsePage(AusbildungPage.class);
			}
		});
		add(new Link("navigateAusruestung") {
			@Override
			public void onClick() {
				setResponsePage(AusruestungPage.class);
			}
		});
		add(new Link("navigateCharge") {
			@Override
			public void onClick() {
				setResponsePage(ChargePage.class);
			}
		});
		add(new Link("navigateFeuerwehr") {
			@Override
			public void onClick() {
				setResponsePage(FeuerwehrPage.class);
			}
		});
		add(new Link("navigateFeuerwehrauto") {
			@Override
			public void onClick() {
				setResponsePage(FeuerwehrautoPage.class);
			}
		});
		add(new Link("navigateGeraet") {
			@Override
			public void onClick() {
				setResponsePage(GeraetPage.class);
			}
		});
	}
}