package at.fdisk.core.webapp.mitglied;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

import at.fdisk.core.domain.Mitglied;
import at.fdisk.core.repository.MitgliedRepository;
import at.fdisk.core.webapp.ContentPanel;

public class MitgliedPanel extends ContentPanel {
	private List<Mitglied> mitgliedList = new ArrayList<>();

	private MitgliedRepository mitgliedRepository;
	
	public MitgliedPanel(String id) {
		super(id);
		
		mitgliedList.addAll(mitgliedRepository.findAll());
		
		add(new MitgliedForm("mitgliedForm", mitgliedList));

		add(new PropertyListView<Mitglied>("mitgliedList", mitgliedList) {
			@Override
			public void populateItem(final ListItem<Mitglied> listItem) {
				listItem.add(new Label("vorname"));
				listItem.add(new Label("nachname"));
				listItem.add(new Label("dienstgrad"));
				listItem.add(new MultiLineLabel("geburtsdatum"));
				listItem.add(new Label("wohnort"));
			}
		}).setVersioned(false);
	}
}
