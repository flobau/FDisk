package at.fdisk.core.webapp.ausbildung;

import java.util.Date;
import java.util.List;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.repository.AusbildungRepository;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AusbildungForm extends Form<Ausbildung> {

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	private List<Ausbildung> ausbildungList;

	@SpringBean
	private AusbildungRepository ausbildungRepository;

	public AusbildungForm(String id, List<Ausbildung> ausbildungList) {
		super(id, new CompoundPropertyModel<Ausbildung>(new Ausbildung("Test", "T", new Date(), new Date())));
		add(new TextField<>("bezeichnung"));
		add(new TextField<>("kurzBezeichnung"));
		add(new TextField<>("startdatum"));
		add(new TextField<>("enddatum"));
		this.ausbildungList = ausbildungList;
	}

	@Override
	public final void onSubmit() {
		Ausbildung ausbildung = getModelObject();
		ausbildungRepository.save(ausbildung);
		logger.error("Ausbildung after save: " + ausbildung);
		ausbildungList.add(ausbildung);
	}
}
