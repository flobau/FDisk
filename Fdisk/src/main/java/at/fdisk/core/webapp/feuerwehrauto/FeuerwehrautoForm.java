package at.fdisk.core.webapp.feuerwehrauto;


import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import at.fdisk.core.domain.Feuerwehrauto;
import at.fdisk.core.repository.FeuerwehrautoRepository;

public class FeuerwehrautoForm extends Form<Feuerwehrauto> {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@SpringBean
	private FeuerwehrautoRepository feuerwehrautoRepository;

	public FeuerwehrautoForm(String id) {
		super(id, new CompoundPropertyModel<Feuerwehrauto>(new Feuerwehrauto()));
		add(new TextField<>("typ"));
		add(new TextField<>("sitzplaetze"));
		add(new TextField<>("feuerwehr"));
	}

	@Override
	public final void onSubmit() {
		Feuerwehrauto feuerwehrauto = getModelObject();
		feuerwehrautoRepository.save(feuerwehrauto);
		logger.error("Feuerwehrauto after save: " + feuerwehrauto);
	}
}
