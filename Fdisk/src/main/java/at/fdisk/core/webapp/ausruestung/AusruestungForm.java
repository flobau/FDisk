package at.fdisk.core.webapp.ausruestung;

import at.fdisk.core.domain.Ausruestung;
import at.fdisk.core.repository.AusruestungRepository;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AusruestungForm extends Form<Ausruestung> {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@SpringBean
	private AusruestungRepository ausreustungRepository;

	public AusruestungForm(String id) {
		super(id, new CompoundPropertyModel<Ausruestung>(new Ausruestung()));
		add(new TextField<>("bezeichnung"));
		add(new TextField<>("ausgegeben"));
	}

	@Override
	public final void onSubmit() {
		Ausruestung ausruestung = getModelObject();
		ausreustungRepository.save(ausruestung);
		logger.error("Ausruestung after save: " + ausruestung);
	}
}
