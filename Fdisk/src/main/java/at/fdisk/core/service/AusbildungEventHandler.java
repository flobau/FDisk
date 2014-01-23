package at.fdisk.core.service;

import java.util.ArrayList;
import java.util.List;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.domain.Feuerwehr;
import at.fdisk.core.events.ausbildung.*;
import at.fdisk.core.repository.AusbildungRepository;

public class AusbildungEventHandler implements AusbildungService {

	private final AusbildungRepository ausbildungRepository;

	public AusbildungEventHandler(
			final AusbildungRepository ausbildungRepository) {
		this.ausbildungRepository = ausbildungRepository;
	}

	@Override
	public AllAusbildungDetailEvent requestAllAusbildung(
			RequestAllAusbildungEvent requestAllCurrentOrdersEvent) {
		List<AusbildungDetails> ausbildungen = new ArrayList<AusbildungDetails>();
		for (Ausbildung ausbildung : ausbildungRepository.findAll()) {
			ausbildungen.add(ausbildung.toAusbildungDetails());
		}
		return new AllAusbildungDetailEvent(ausbildungen);
	}

	@Override
	public AusbildungDetailsEvent requestAusbildungDetails(
			RequestAusbildungDetailsEvent requestAusbildungDetailsEvent) {
		Ausbildung ausbildung = ausbildungRepository
				.findByBezeichnung(requestAusbildungDetailsEvent
						.getBezeichnung());
		if (ausbildung == null) {
			return AusbildungDetailsEvent
					.notFound(requestAusbildungDetailsEvent.getBezeichnung());
		}
		return new AusbildungDetailsEvent(
				requestAusbildungDetailsEvent.getBezeichnung(),
				ausbildung.toAusbildungDetails());
	}

	@Override
	public AusbildungCreateEvent createAusbildung(
			CreateAusbildungEvent createAusbildungEvent) {
		Ausbildung ausbildung = Ausbildung
				.fromOrderDetails(createAusbildungEvent.getDetails());
		ausbildung.setOrt(new Feuerwehr());
		ausbildung = ausbildungRepository.save(ausbildung);
		return new AusbildungCreateEvent(ausbildung.getBezeichnung(),
				ausbildung.toAusbildungDetails());
	}

	@Override
	public AusbildungDeletedEvent deleteAusbildung(DeleteAusbildungEvent deleteAusbildungEvent) {
		    Ausbildung ausbildung = ausbildungRepository.findByBezeichnung(deleteAusbildungEvent.getBezeichnung());

		    if (ausbildung == null) {
		      return AusbildungDeletedEvent.notFound(deleteAusbildungEvent.getBezeichnung());
		    }

		    AusbildungDetails details = ausbildung.toAusbildungDetails();

		    //TODOCUMENT This contains some specific domain logic, not exposed to the outside world, and not part of the
		    //persistence rules.

		    if (!ausbildung.canBeDeleted()) {
		      return AusbildungDeletedEvent.deletionForbidden(deleteAusbildungEvent.getBezeichnung(), details);
		    }
		    Long id = ausbildungRepository.findByBezeichnung(deleteAusbildungEvent.getBezeichnung()).getId();
		    
		    ausbildungRepository.delete(id);
		    return new AusbildungDeletedEvent(deleteAusbildungEvent.getBezeichnung(), details);
	}
}
