package at.fdisk.core.webapp;

import org.apache.wicket.markup.html.panel.Panel;

import at.fdisk.core.webapp.ausbildung.AusbildungPage;
import at.fdisk.core.webapp.ausbildung.NewAusbildungPage;
import at.fdisk.core.webapp.ausruestung.AusruestungPage;
import at.fdisk.core.webapp.ausruestung.NewAusruestungPage;
import at.fdisk.core.webapp.feuerwehrauto.FeuerwehrautoPage;
import at.fdisk.core.webapp.geraet.GeraetPage;
import at.fdisk.core.webapp.mitglied.MitgliedPage;

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
		add(new Link("navigateAusruestung") {
			@Override
			public void onClick() {
				setResponsePage(AusruestungPage.class);
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
		add(new Link("navigateMitglied") {
			@Override
			public void onClick() {
				setResponsePage(MitgliedPage.class);
			}
		});
		add(new Link("insertAusbildung"){
			@Override
			public void onClick() {
				setResponsePage(NewAusbildungPage.class);
			}
		});
		add(new Link("insertAusruestung"){
			@Override
			public void onClick(){
				setResponsePage(NewAusruestungPage.class);
			}
		});
	}
}