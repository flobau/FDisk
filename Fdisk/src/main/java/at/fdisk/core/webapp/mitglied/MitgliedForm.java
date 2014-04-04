package at.fdisk.core.webapp.mitglied;

import java.util.List;

import at.fdisk.core.domain.Mitglied;
import at.fdisk.core.repository.MitgliedRepository;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MitgliedForm extends Form<Mitglied> {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	private List<Mitglied> mitgliedList;

	@SpringBean
	private MitgliedRepository mitgliedRepository;

	public MitgliedForm(String id, List<Mitglied> mitglied) {
		super(id, new CompoundPropertyModel<Mitglied>(new Mitglied()));
		add(new TextField<>("vorname"));
		add(new TextField<>("nachname"));
		add(new TextField<>("dienstgrad"));
		add(new TextField<>("geburtsdatum"));
		add(new TextField<>("wohnort"));
		this.mitgliedList = mitgliedList;
	}

	@Override
	public final void onSubmit() {
		Mitglied mitglied = getModelObject();
		mitgliedRepository.save(mitglied);
		logger.error("Mitglied after save: " + mitglied);
		mitgliedList.add(mitglied);
	}
}
