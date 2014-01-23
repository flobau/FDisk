package at.fdisk.core.events.ausbildung;

public class AusbildungCreateEvent {

	private final String newBezeichnung;
	private final AusbildungDetails details;

	public AusbildungCreateEvent(final String newBezeichnung, final AusbildungDetails details) {
		this.newBezeichnung = newBezeichnung;
		this.details = details;
	}

	public AusbildungDetails getDetails() {
		return details;
	}

	public String getNewOrderKey() {
		return newBezeichnung;
	}

}
