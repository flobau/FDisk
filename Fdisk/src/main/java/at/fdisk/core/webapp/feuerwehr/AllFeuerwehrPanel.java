package at.fdisk.core.webapp.feuerwehr;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.service.FdiskManagementService;
import at.fdisk.core.webapp.ContentPanel;

public class AllFeuerwehrPanel extends ContentPanel {

	FdiskManagementService service = new FdiskManagementService();

	public AllFeuerwehrPanel(String id) {
		super(id);

		List ausbildungList = Collections.synchronizedList(service.getAllAusbildungen());
		
		if(ausbildungList.size() < 1){
			ausbildungList.add(new Ausbildung("keine", "Ausbildung", new Date(), new Date()));
		}
		
		add(new PropertyListView<Ausbildung>("listView", ausbildungList) {
            @Override
            public void populateItem(final ListItem<Ausbildung> listItem) {
            	Ausbildung ausbildung = (Ausbildung) listItem.getModelObject();
                listItem.add(new Label("date", ausbildung.getBezeichnung()));
                //listItem.add(new MultiLineLabel("text"));
            }
        }).setVersioned(false);
	}
}
