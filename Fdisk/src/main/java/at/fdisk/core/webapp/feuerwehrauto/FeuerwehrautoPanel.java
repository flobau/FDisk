package at.fdisk.core.webapp.feuerwehrauto;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

import at.fdisk.core.domain.Ausruestung;
import at.fdisk.core.domain.Feuerwehrauto;
import at.fdisk.core.webapp.ContentPanel;

public class FeuerwehrautoPanel extends ContentPanel {
	private List<Feuerwehrauto> feuerwehrautoList = new ArrayList<Feuerwehrauto>();

	public FeuerwehrautoPanel(String id) {
		super(id);
		add(new FeuerwehrautoForm("feuerwehrautoForm", feuerwehrautoList));

		add(new PropertyListView<Feuerwehrauto>("feuerwehrautoList",
						feuerwehrautoList) {
					@Override
					public void populateItem(
							final ListItem<Feuerwehrauto> listItem) {
						listItem.add(new Label("typ"));
						listItem.add(new Label("sitzplaetze"));
						listItem.add(new Label("feuerwehr"));
					}
				}).setVersioned(false);
	}
}
