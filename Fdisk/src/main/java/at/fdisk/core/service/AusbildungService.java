package at.fdisk.core.service;

import at.fdisk.core.events.ausbildung.*;

public interface AusbildungService {

	public AllAusbildungDetailEvent requestAllAusbildung(
			RequestAllAusbildungEvent requestAllCurrentAusbildungEvent);

	public AusbildungDetailsEvent requestAusbildungDetails(
			RequestAusbildungDetailsEvent requestAusbildungDetailsEvent);

	public AusbildungCreateEvent createAusbildung(
			CreateAusbildungEvent createAusbildungEvent);

	public AusbildungDeletedEvent deleteAusbildung(
			DeleteAusbildungEvent deleteAusbildungEvent);

}
