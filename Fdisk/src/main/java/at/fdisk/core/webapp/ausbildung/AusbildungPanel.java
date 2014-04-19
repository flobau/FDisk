package at.fdisk.core.webapp.ausbildung;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.OrderByBorder;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.ReuseIfModelsEqualStrategy;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.webapp.ContentPanel;

public class AusbildungPanel extends ContentPanel {
	
	private final Form<?> form;
	
	public AusbildungPanel(String id) {
		super(id);
		
		form = new Form(id);

		SortableAusbildungDataProvider dp = new SortableAusbildungDataProvider();

		final DataView<Ausbildung> dataView = new DataView<Ausbildung>(
				"ausbildungdataview", dp) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(final Item<Ausbildung> item) {
				Ausbildung ausbildung = item.getModelObject();
				item.add(new ActionPanel("actions", item.getModel()));
				item.add(new Label("bezeichnung", ausbildung.getBezeichnung()));
				item.add(new Label("kurzBezeichnung", ausbildung
						.getKurzBezeichnung()));
				item.add(new Label("startDatum", ausbildung.getStartdatum()));
				item.add(new Label("endDatum", ausbildung.getEnddatum()));

				item.add(AttributeModifier.replace("class",
						new AbstractReadOnlyModel<String>() {
							private static final long serialVersionUID = 1L;

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

		add(new OrderByBorder("orderByBezeichnung", "bezeichnung", dp) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSortChanged() {
				dataView.setCurrentPage(0);
			}
		});

		add(dataView);
	}
	
	private class ActionPanel extends Panel
	{
		public ActionPanel(String id, IModel<Ausbildung> model)
		{
			super(id, model);
			SubmitLink removeLink = new SubmitLink("remove", form)
			{
				@Override
				public void onSubmit()
				{
					Ausbildung ausbildung = (Ausbildung)ActionPanel.this.getDefaultModelObject();
					info("Removed Ausbildung " + ausbildung);
					DatabaseLocator.getDatabase().delete(ausbildung);
				}
			};
			removeLink.setDefaultFormProcessing(false);
			add(removeLink);
		}
	}
}
