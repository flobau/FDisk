package at.fdisk.core.webapp.mitglied;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import at.fdisk.core.domain.Mitglied;
import at.fdisk.core.webapp.DatabaseLocator;

public class NewMitgliedForm extends Form<Mitglied>{

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	public NewMitgliedForm(String id) {
		super(id, new CompoundPropertyModel<Mitglied>(new Mitglied()));
		add(new TextField<>("vorname"));
		add(new TextField<>("nachname"));
		add(new TextField<>("dienstgrad"));
		add(new TextField<>("geburtsdatum"));
		add(new TextField<>("wohnort"));
	}

	@Override
	public final void onSubmit() {
		Mitglied geraet = getModelObject();
		getDB().save(geraet);
	}
	
	protected MitgliedDB getDB(){
		return DatabaseLocator.getMitgliedDatabase();
	}
}
