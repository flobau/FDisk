package at.fdisk.core.webapp;

import org.apache.wicket.markup.html.panel.Panel;

import at.fdisk.core.webapp.ausbildung.AusbildungPage;
import at.fdisk.core.webapp.ausbildung.AllAusbildungPage;
import at.fdisk.core.webapp.ausruestung.AllAusruestungPage;
import at.fdisk.core.webapp.ausruestung.AusruestungPage;
import at.fdisk.core.webapp.charge.AllChargePage;
import at.fdisk.core.webapp.charge.ChargePage;
import at.fdisk.core.webapp.feuerwehr.AllFeuerwehrPage;
import at.fdisk.core.webapp.feuerwehr.FeuerwehrPage;
import at.fdisk.core.webapp.feuerwehrauto.AllFeuerwehrautoPage;
import at.fdisk.core.webapp.feuerwehrauto.FeuerwehrautoPage;
import at.fdisk.core.webapp.geraet.AllGeraetPage;
import at.fdisk.core.webapp.geraet.GeraetPage;
import at.fdisk.core.webapp.mitglied.AllMitgliedPage;
import at.fdisk.core.webapp.mitglied.MitgliedPage;
import at.fdisk.core.webapp.playground.TestPage;

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
		add(new Link("navigateMitglied") {
			@Override
			public void onClick() {
				setResponsePage(MitgliedPage.class);
			}
		});
		add(new Link("alleAusbildungen") {
			@Override
			public void onClick() {
				setResponsePage(AllAusbildungPage.class);
			}
		});
		add(new Link("alleAusruestung") {
			@Override
			public void onClick() {
				setResponsePage(AllAusruestungPage.class);
			}
		});
		add(new Link("alleCharge") {
			@Override
			public void onClick() {
				setResponsePage(AllChargePage.class);
			}
		});
		add(new Link("alleFeuerwehr") {
			@Override
			public void onClick() {
				setResponsePage(AllFeuerwehrPage.class);
			}
		});
		add(new Link("alleFeuerwehrauto") {
			@Override
			public void onClick() {
				setResponsePage(AllFeuerwehrautoPage.class);
			}
		});
		add(new Link("alleGeraet") {
			@Override
			public void onClick() {
				setResponsePage(AllGeraetPage.class);
			}
		});
		add(new Link("alleMitglied") {
			@Override
			public void onClick() {
				setResponsePage(AllMitgliedPage.class);
			}
		});
		add(new Link("testing") {
			@Override
			public void onClick() {
				setResponsePage(TestPage.class);
			}
		});
	}
}