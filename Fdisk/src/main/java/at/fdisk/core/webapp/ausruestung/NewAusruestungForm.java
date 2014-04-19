package at.fdisk.core.webapp.ausruestung;

import java.util.Date;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import at.fdisk.core.domain.Ausruestung;
import at.fdisk.core.webapp.DatabaseLocator;

public class NewAusruestungForm extends Form<Ausruestung>{

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	public NewAusruestungForm(String id) {
		super(id, new CompoundPropertyModel<Ausruestung>(new Ausruestung()));
		add(new TextField<>("bezeichnung"));
		add(new TextField<>("benutzer"));
		add(new TextField<>("ausgegeben"));
	}

	@Override
	public final void onSubmit() {
		Ausruestung ausruestung = getModelObject();
		getDB().save(ausruestung);
	}
	
	protected AusruestungDB getDB(){
		return DatabaseLocator.getAusruestungDatabase();
	}
}
