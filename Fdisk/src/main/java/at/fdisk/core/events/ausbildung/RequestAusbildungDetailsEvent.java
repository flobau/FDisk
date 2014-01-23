package at.fdisk.core.events.ausbildung;

import at.fdisk.core.events.RequestReadEvent;

public class RequestAusbildungDetailsEvent extends RequestReadEvent {
	private String bezeichnung;

	public RequestAusbildungDetailsEvent(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}
}
