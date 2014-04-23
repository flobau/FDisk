package at.fdisk.core.webapp.feuerwehrauto;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import at.fdisk.core.domain.Feuerwehrauto;
import at.fdisk.core.webapp.DatabaseLocator;

public class NewFeuerwehrautoForm extends Form<Feuerwehrauto>{

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	public NewFeuerwehrautoForm(String id) {
		super(id, new CompoundPropertyModel<Feuerwehrauto>(new Feuerwehrauto()));
		add(new TextField<>("typ"));
		add(new TextField<>("sitzplaetze"));
	}

	@Override
	public final void onSubmit() {
		Feuerwehrauto feuerwehrauto = getModelObject();
		getDB().save(feuerwehrauto);
	}
	
	protected FeuerwehrautoDB getDB(){
		return DatabaseLocator.getFeuerwehrautoDatabase();
	}
}
