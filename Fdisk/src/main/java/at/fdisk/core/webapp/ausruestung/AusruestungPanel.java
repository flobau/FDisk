package at.fdisk.core.webapp.ausruestung;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.OrderByBorder;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.ReuseIfModelsEqualStrategy;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;

import at.fdisk.core.domain.Ausruestung;
import at.fdisk.core.webapp.ContentPanel;
import at.fdisk.core.webapp.DatabaseLocator;

public class AusruestungPanel extends ContentPanel {

	private final Form<?> form;
	
	public AusruestungPanel(String id) {
		super(id);
		
		form = new Form("form");
		add(form);
		
		SortableAusruestungDataProvider dp = new SortableAusruestungDataProvider();
		
		final DataView<Ausruestung> dataView = new DataView<Ausruestung>("ausruestungDataView", dp){
			@Override
			protected void populateItem(final Item<Ausruestung> item){
				Ausruestung ausruestung = item.getModelObject();
				item.add(new ActionPanel("actions", item.getModel()));
				item.add(new Label("bezeichnung", ausruestung.getBezeichnung()));
				item.add(new Label("benutzer", ausruestung.getBenutzer()));
				item.add(new Label("ausgegeben", ausruestung.getAusgegeben()));
				
				item.add(AttributeModifier.replace("class", new AbstractReadOnlyModel<String>() {
					@Override
					public String getObject() {
						return (item.getIndex() % 2 == 1) ? "even"
								: "odd";
					}
				}));
			}
		};
		
		dataView.setItemsPerPage(8L);
		dataView.setItemReuseStrategy(ReuseIfModelsEqualStrategy.getInstance());
		
		form.add(new OrderByBorder("orderByBezeichnung", "bezeichnung", dp) {
			@Override
			protected void onSortChanged() {
				dataView.setCurrentPage(0);
			}
		});
		
		form.add(dataView);
	}
	
	private class ActionPanel extends Panel
	{
		public ActionPanel(String id, IModel<Ausruestung> model)
		{
			super(id, model);
			SubmitLink removeLink = new SubmitLink("remove", form)
			{
				@Override
				public void onSubmit()
				{
					Ausruestung ausruestung = (Ausruestung)ActionPanel.this.getDefaultModelObject();
					info("Removed Ausruestung " + ausruestung);
					DatabaseLocator.getAusruestungDatabase().delete(ausruestung);
				}
			};
			removeLink.setDefaultFormProcessing(false);
			add(removeLink);
		}
	}
}
