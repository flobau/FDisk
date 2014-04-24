package at.fdisk.core.webapp.mitglied;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
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
		add(new FeedbackPanel("feedback"));
	}

	@Override
	public final void onSubmit() {
		boolean mistake = false;
		if(getModelObject().getVorname().matches(".*\\d.*")){
			error("Vorname darf keine Zahlen enthalten");
			mistake = true;
		}
		if(getModelObject().getNachname().matches(".*\\d.*")){
			error("Nachname darf keine Zahlen enthalten");
			mistake = true;
		}
		if(getModelObject().getDienstgrad().matches(".*\\d.*")){
			error("Dienstgrad darf keine Zahlen enthalten");
			mistake = true;
		}
		if(getModelObject().getWohnort().matches(".*\\d.*")){
			error("Wohnort darf keine Zahlen enthalten");
			mistake = true;
		}
		if(mistake == false){
			Mitglied geraet = getModelObject();
			getDB().save(geraet);
		}
	}
	
	protected MitgliedDB getDB(){
		return DatabaseLocator.getMitgliedDatabase();
	}
}
