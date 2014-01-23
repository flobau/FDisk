package at.fdisk.core.events.ausbildung;

public class CreateAusbildungEvent {
	private AusbildungDetails ausbildungDetails;

	public CreateAusbildungEvent(AusbildungDetails details) {
		this.ausbildungDetails = details;
	}

	public AusbildungDetails getDetails() {
		return ausbildungDetails;
	}
}
