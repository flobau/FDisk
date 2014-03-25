package at.fdisk.core.webapp.feuerwehr;

import at.fdisk.core.domain.Feuerwehr;
import at.fdisk.core.repository.FeuerwehrRepository;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FeuerwehrForm extends Form<Feuerwehr> {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@SpringBean
	private FeuerwehrRepository feuerwehrRepository;

	public FeuerwehrForm(String id) {
		super(id, new CompoundPropertyModel<Feuerwehr>(new Feuerwehr()));
		add(new TextField<>("ort"));
		add(new TextField<>("kommandant"));
	}

	@Override
	public final void onSubmit() {
		Feuerwehr feuerwehr = getModelObject();
		feuerwehrRepository.save(feuerwehr);
		logger.error("Feuerwehr after save: " + feuerwehr);
	}
}
