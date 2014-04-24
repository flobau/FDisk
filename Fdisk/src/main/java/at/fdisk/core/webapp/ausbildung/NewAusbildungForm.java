package at.fdisk.core.webapp.ausbildung;

import java.util.Date;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.webapp.DatabaseLocator;

public class NewAusbildungForm extends Form<Ausbildung>{

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	public NewAusbildungForm(String id) {
		super(id, new CompoundPropertyModel<Ausbildung>(new Ausbildung()));
		add(new TextField<>("bezeichnung"));
		add(new TextField<>("kurzBezeichnung"));
		add(new TextField<>("startdatum"));
		add(new TextField<>("enddatum"));
	}

	@Override
	public final void onSubmit() {
		Ausbildung ausbildung = getModelObject();
		getDB().save(ausbildung);
	}
	
	protected AusbildungDB getDB(){
		return DatabaseLocator.getAusbildungDatabase();
	}
}
