package at.fdisk.core.service;

import java.util.ArrayList;
import java.util.List;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.events.impl.AllAusbildungEvent;
import at.fdisk.core.events.impl.RequestAllAusbildungEvent;
import at.fdisk.core.repository.AusbildungRepository;
import at.fdisk.core.repository.impl.AusbildungRepositoryImpl;

public class AusbildungEventHandler implements AusbildungService {

	private final AusbildungRepository ausbildungRepository;

	public AusbildungEventHandler(final AusbildungRepository ausbildungRepository) {
		this.ausbildungRepository = ausbildungRepository;
	}

	@Override
	public AllAusbildungEvent requestAllAusbildung(
			RequestAllAusbildungEvent requestAllCurrentOrdersEvent) {
		List<Ausbildung> ausbildungen = new ArrayList<Ausbildung>();
		for (Ausbildung ausbildung : ausbildungRepository.findAll()) {
		//	ausbildungen.add(ausbildung.toOrderDetails());
		}
		return new AllAusbildungEvent(ausbildungen);
	}
}
