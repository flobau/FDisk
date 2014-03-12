package at.fdisk.core.webapp.ausbildung;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.repository.AusbildungRepository;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.Date;

/**
 *
 */
public class AusbildungForm extends Form<Ausbildung> {

	@SpringBean
	private AusbildungRepository ausbildungRepository;

	public AusbildungForm(String id) {
		super(id, new CompoundPropertyModel<Ausbildung>(new Ausbildung(
				"TestAusbildung", "TA", new Date(), new Date())));
		add(new TextField<>("Bezeichnung"));
		add(new TextField<>("KurzBezeichnung"));
		add(new TextField<>("StartDate"));
		add(new TextField<>("EndDate"));
	}

	@Override
	public final void onSubmit() {
		Ausbildung ausbildung = getModelObject();
		ausbildungRepository.save(ausbildung);
		System.out.println(ausbildung);
	}
}
