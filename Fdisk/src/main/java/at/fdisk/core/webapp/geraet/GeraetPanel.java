package at.fdisk.core.webapp.geraet;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

import at.fdisk.core.domain.Feuerwehrauto;
import at.fdisk.core.domain.Geraet;
import at.fdisk.core.webapp.ContentPanel;

public class GeraetPanel extends ContentPanel {
	private List<Geraet> geraetList = new ArrayList<>();

	public GeraetPanel(String id) {
		super(id);
		add(new GeraetForm("geraetForm", geraetList));

		add(new PropertyListView<Geraet>("geraetList", geraetList) {
			@Override
			public void populateItem(final ListItem<Geraet> listItem) {
				listItem.add(new Label("bezeichnung"));
				listItem.add(new MultiLineLabel("prueftermin"));
				listItem.add(new Label("auto"));
			}
		}).setVersioned(false);
	}
}
