package at.fdisk.core.webapp.charge;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

import at.fdisk.core.domain.Ausruestung;
import at.fdisk.core.domain.Charge;
import at.fdisk.core.webapp.ContentPanel;

public class ChargePanel extends ContentPanel {
	private List<Charge> chargeList = new ArrayList<Charge>();
	
	public ChargePanel(String id) {
		super(id);
		add(new ChargeForm("chargeForm", chargeList));
		
		add(new PropertyListView<Charge>("chargeList", chargeList) {
			@Override
			public void populateItem(final ListItem<Charge> listItem) {
				listItem.add(new Label("vorname"));
				listItem.add(new Label("nachname"));
				listItem.add(new Label("dienstgrad"));
				listItem.add(new MultiLineLabel("geburtsdatum"));
				listItem.add(new Label("wohnort"));
				listItem.add(new Label("fachgebiet"));
			}
		}).setVersioned(false);
	}
}
