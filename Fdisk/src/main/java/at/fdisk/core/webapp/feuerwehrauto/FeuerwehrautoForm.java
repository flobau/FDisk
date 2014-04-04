package at.fdisk.core.webapp.feuerwehrauto;


import java.util.List;

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
	private List<Feuerwehrauto> feuerwehrautoList;
	
	@SpringBean
	private FeuerwehrautoRepository feuerwehrautoRepository;

	public FeuerwehrautoForm(String id, List<Feuerwehrauto> feuerwehrautoList) {
		super(id, new CompoundPropertyModel<Feuerwehrauto>(new Feuerwehrauto()));
		add(new TextField<>("typ"));
		add(new TextField<>("sitzplaetze"));
		add(new TextField<>("feuerwehr"));
		this.feuerwehrautoList = feuerwehrautoList;
	}

	@Override
	public final void onSubmit() {
		Feuerwehrauto feuerwehrauto = getModelObject();
		feuerwehrautoRepository.save(feuerwehrauto);
		logger.error("Feuerwehrauto after save: " + feuerwehrauto);
		feuerwehrautoList.add(feuerwehrauto);
	}
}
