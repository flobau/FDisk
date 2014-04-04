package at.fdisk.core.webapp.geraet;


import java.util.List;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import at.fdisk.core.domain.Geraet;
import at.fdisk.core.repository.GeraetRepository;

public class GeraetForm extends Form<Geraet> {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	private List<Geraet> geraetList;

	@SpringBean
	private GeraetRepository geraetRepository;

	public GeraetForm(String id, List<Geraet> geraetList) {
		super(id, new CompoundPropertyModel<Geraet>(new Geraet()));
		add(new TextField<>("bezeichnung"));
		add(new TextField<>("pruefungstermin"));
		add(new TextField<>("auto"));
		this.geraetList = geraetList;
	}

	@Override
	public final void onSubmit() {
		Geraet geraet = getModelObject();
		geraetRepository.save(geraet);
		logger.error("Gerät after save: " + geraet);
		geraetList.add(geraet);
	}
}
