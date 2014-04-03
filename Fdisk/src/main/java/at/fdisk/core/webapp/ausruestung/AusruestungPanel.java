package at.fdisk.core.webapp.ausruestung;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

import at.fdisk.core.domain.Ausruestung;
import at.fdisk.core.webapp.ContentPanel;

public class AusruestungPanel extends ContentPanel {
	private List<Ausruestung> ausruestungList = new ArrayList<>();
	
	public AusruestungPanel(String id) {
		super(id);
		add(new AusruestungForm("ausruestungForm", ausruestungList));
		
		add(new PropertyListView<Ausruestung>("ausruestungList", ausruestungList) {
			@Override
			public void populateItem(final ListItem<Ausruestung> listItem) {
				listItem.add(new Label("bezeichnung"));
				listItem.add(new Label("ausgegeben"));
			}
		}).setVersioned(false);
	}
}
