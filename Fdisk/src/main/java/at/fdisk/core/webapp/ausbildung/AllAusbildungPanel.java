package at.fdisk.core.webapp.ausbildung;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.repository.AusbildungRepository;
import at.fdisk.core.webapp.ContentPanel;

public class AllAusbildungPanel extends ContentPanel {
	
	public AllAusbildungPanel(String id) {
		super(id);
		
		List userList = Arrays.asList(new Ausbildung[] {
		        new Ausbildung("FirstA", "LastA", new Date(), new Date()),
		        new Ausbildung("FirstB", "LastB", new Date(), new Date()),
		        new Ausbildung("FirstC", "LastC", new Date(), new Date())
		      });
		
		add(new ListView<Object>("listview", userList) {
			protected void populateItem(ListItem item) {
				Ausbildung ausbildung = (Ausbildung) item.getModelObject();
				item.add(new Label("bezeichnung", ausbildung.getBezeichnung()));
			}
		});
	}
}
