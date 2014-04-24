package at.fdisk.core.webapp.ausbildung;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.webapp.DatabaseLocator;

public class NewAusbildungForm extends Form<Ausbildung>{

	private static final long serialVersionUID = 1L;

	public NewAusbildungForm(String id) {
		super(id, new CompoundPropertyModel<Ausbildung>(new Ausbildung()));
		add(new TextField<>("bezeichnung"));
		add(new TextField<>("kurzBezeichnung"));
		add(new TextField<>("startdatum"));
		add(new TextField<>("enddatum"));
		add(new FeedbackPanel("feedback"));
	}

	@Override
	public final void onSubmit() {
		if(getModelObject().getEnddatum().compareTo(getModelObject().getStartdatum()) < 0){
			error("Enddatum darf nicht vor dem Startdatum liegen!");
			return;
		}
		Ausbildung ausbildung = getModelObject();
		getDB().save(ausbildung);
	}
	
	protected AusbildungDB getDB(){
		return DatabaseLocator.getAusbildungDatabase();
	}
}
