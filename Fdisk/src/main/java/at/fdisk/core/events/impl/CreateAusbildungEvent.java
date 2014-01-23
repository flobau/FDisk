package at.fdisk.core.events.impl;

import at.fdisk.core.domain.Ausbildung;

public class CreateAusbildungEvent {
	private Ausbildung ausbildung;

	public CreateAusbildungEvent(Ausbildung details) {
		this.ausbildung = details;
	}

	public Ausbildung getDetails() {
		return ausbildung;
	}
}
