package at.fdisk.core.webapp.geraet;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.OrderByBorder;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;
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
import org.apache.wicket.spring.injection.annot.SpringBean;

import at.fdisk.core.domain.Geraet;
import at.fdisk.core.repository.GeraetRepository;
import at.fdisk.core.webapp.ContentPanel;
import at.fdisk.core.webapp.DatabaseLocator;

public class GeraetPanel extends ContentPanel {
private final Form<?> form;
	
	public GeraetPanel(String id) {
		super(id);
		
		form = new Form("form");
		add(form);
		
		SortableGeraetDataProvider dp = new SortableGeraetDataProvider();
		
		final DataView<Geraet> dataView = new DataView<Geraet>("geraetDataView", dp){
			@Override
			protected void populateItem(final Item<Geraet> item){
				Geraet geraet = item.getModelObject();
				item.add(new ActionPanel("actions", item.getModel()));
				item.add(new Label("bezeichnung", geraet.getBezeichnung()));
				item.add(new Label("pruefungstermin", geraet.getPruefungstermin()));
				
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
		
		form.add(new OrderByBorder("orderByTyp", "typ", dp) {
			@Override
			protected void onSortChanged() {
				dataView.setCurrentPage(0);
			}
		});
		
		form.add(dataView);
	}
	
	private class ActionPanel extends Panel
	{
		public ActionPanel(String id, IModel<Geraet> model)
		{
			super(id, model);
			SubmitLink removeLink = new SubmitLink("remove", form)
			{
				@Override
				public void onSubmit()
				{
					Geraet feuerwehrauto = (Geraet)ActionPanel.this.getDefaultModelObject();
					info("Removed Ausruestung " + feuerwehrauto);
					DatabaseLocator.getGeraetDatabase().delete(feuerwehrauto);
				}
			};
			removeLink.setDefaultFormProcessing(false);
			add(removeLink);
		}
	}
}
