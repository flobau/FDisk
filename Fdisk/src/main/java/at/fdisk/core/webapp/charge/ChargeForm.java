package at.fdisk.core.webapp.charge;

import at.fdisk.core.domain.Charge;
import at.fdisk.core.repository.ChargeRepository;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChargeForm extends Form<Charge> {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@SpringBean
	private ChargeRepository chargeRepository;

	public ChargeForm(String id) {
		super(id, new CompoundPropertyModel<Charge>(new Charge()));
		add(new TextField<>("vorname"));
		add(new TextField<>("nachname"));
		add(new TextField<>("dienstgrad"));
		add(new TextField<>("geburtsdatum"));
		add(new TextField<>("wohnort"));
		add(new TextField<>("fachgebiet"));
	}

	@Override
	public final void onSubmit() {
		Charge charge = getModelObject();
		chargeRepository.save(charge);
		logger.error("Charge after save: " + charge);
	}
}
