package at.fdisk.core.webapp.feuerwehr;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

import at.fdisk.core.domain.Ausruestung;
import at.fdisk.core.domain.Feuerwehr;
import at.fdisk.core.webapp.ContentPanel;

public class FeuerwehrPanel extends ContentPanel {
	private List<Feuerwehr> feuerwehrList = new ArrayList<Feuerwehr>();
	
	public FeuerwehrPanel(String id) {
		super(id);
		add(new FeuerwehrForm("feuerwehrForm", feuerwehrList));
		
		add(new PropertyListView<Feuerwehr>("feuerwehrList", feuerwehrList) {
			@Override
			public void populateItem(final ListItem<Feuerwehr> listItem) {
				listItem.add(new Label("ort"));
				listItem.add(new Label("kommandant"));
			}
		}).setVersioned(false);
	}
}
