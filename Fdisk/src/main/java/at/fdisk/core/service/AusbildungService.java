package at.fdisk.core.service;

import at.fdisk.core.events.impl.*;

public interface AusbildungService {

	public AllAusbildungEvent requestAllAusbildung(RequestAllAusbildungEvent requestAllCurrentAusbildungEvent);

}
