package at.fdisk.core.webapp.playground;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import at.fdisk.core.domain.Ausbildung;

public class TestPanel extends Panel {

	private final IModel<List<Ausbildung>> ausbildungen;

	public TestPanel(String id, IModel<List<Ausbildung>> model) {
		super(id, model);
		ausbildungen = model;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		add(new ListView<Ausbildung>("list", ausbildungen.getObject()) {

			@Override
			protected void populateItem(ListItem<Ausbildung> item) {
				item.add(new Label("ausbildung", item.getModelObject().getBezeichnung()));
				item.add(new Label("kurzbez.", item.getModelObject().getKurzBezeichnung()));
			}
		});
	}
}
