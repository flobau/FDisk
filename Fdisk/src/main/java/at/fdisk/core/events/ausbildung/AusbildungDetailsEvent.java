package at.fdisk.core.events.ausbildung;

import at.fdisk.core.events.ReadEvent;

public class AusbildungDetailsEvent extends ReadEvent {
	private String bezeichnung;
	private AusbildungDetails ausbildungDetails;

	private AusbildungDetailsEvent(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public AusbildungDetailsEvent(String bezeichnung,
			AusbildungDetails ausbildungDetails) {
		this.bezeichnung = bezeichnung;
		this.ausbildungDetails = ausbildungDetails;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public AusbildungDetails getOrderDetails() {
		return ausbildungDetails;
	}

	public static AusbildungDetailsEvent notFound(String bezeichnung) {
		AusbildungDetailsEvent ev = new AusbildungDetailsEvent(bezeichnung);
		ev.entityFound = false;
		return ev;
	}
}
