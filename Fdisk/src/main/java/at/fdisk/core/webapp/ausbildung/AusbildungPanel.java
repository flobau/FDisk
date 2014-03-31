package at.fdisk.core.webapp.ausbildung;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.webapp.ContentPanel;

public class AusbildungPanel extends ContentPanel {
	private List<Ausbildung> ausbildungList;

	public AusbildungPanel(String id) {
		super(id);
		add(new AusbildungForm("ausbildungForm", ausbildungList));

		add(new PropertyListView<Ausbildung>("ausbildungList", ausbildungList) {
			@Override
			public void populateItem(final ListItem<Ausbildung> listItem) {
				listItem.add(new Label("bezeichnung"));
				listItem.add(new Label("kurzBezeichnung"));
				listItem.add(new MultiLineLabel("startdatum"));
				listItem.add(new MultiLineLabel("enddatum"));
			}
		}).setVersioned(false);
	}
}
