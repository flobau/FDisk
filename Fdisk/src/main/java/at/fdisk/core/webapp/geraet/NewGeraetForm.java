package at.fdisk.core.webapp.geraet;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import at.fdisk.core.domain.Geraet;
import at.fdisk.core.webapp.DatabaseLocator;

public class NewGeraetForm extends Form<Geraet>{

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	public NewGeraetForm(String id) {
		super(id, new CompoundPropertyModel<Geraet>(new Geraet()));
		add(new TextField<>("bezeichnung"));
		add(new TextField<>("pruefungstermin"));
	}

	@Override
	public final void onSubmit() {
		Geraet geraet = getModelObject();
		getDB().save(geraet);
	}
	
	protected GeraetDB getDB(){
		return DatabaseLocator.getGeraetDatabase();
	}
}
