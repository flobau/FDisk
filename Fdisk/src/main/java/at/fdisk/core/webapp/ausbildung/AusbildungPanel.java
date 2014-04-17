package at.fdisk.core.webapp.ausbildung;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.repository.AusbildungRepository;
import at.fdisk.core.webapp.ContentPanel;

public class AusbildungPanel extends ContentPanel {
	public AusbildungPanel(String id) {
		super(id);
		
		add(new DataView<Ausbildung>("simple", new AusbildungDataProvider()){

			@Override
			protected void populateItem(final Item<Ausbildung> item) {
				Ausbildung ausbildung = item.getModelObject();
				item.add(new Label("bezeichnung", ausbildung.getBezeichnung()));
				item.add(new Label("kurzBezeichnung", ausbildung.getKurzBezeichnung()));
				item.add(new Label("startDatum", ausbildung.getStartdatum()));
				item.add(new Label("endDatum", ausbildung.getEnddatum()));
				
				item.add(AttributeModifier.replace("class", new AbstractReadOnlyModel<String>()
				{
					private static final long serialVersionUID = 1L;

					@Override
					public String getObject()
					{
						return (item.getIndex() % 2 == 1) ? "even" : "odd";
					}
				}));
			}
			
		});
	}
}
