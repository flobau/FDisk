package at.fdisk.core.events.ausbildung;

import at.fdisk.core.events.DeletedEvent;

public class AusbildungDeletedEvent extends DeletedEvent{

	private String key;
	private AusbildungDetails details;
	private boolean deletionCompleted;

	private AusbildungDeletedEvent(String key) {
		this.key = key;
	}

	public AusbildungDeletedEvent(String key, AusbildungDetails details) {
		this.key = key;
		this.details = details;
		this.deletionCompleted = true;
	}

	public String getKey() {
		return key;
	}

	public AusbildungDetails getDetails() {
		return details;
	}

	public boolean isDeletionCompleted() {
		return deletionCompleted;
	}

	public static AusbildungDeletedEvent deletionForbidden(String key,
			AusbildungDetails details) {
		AusbildungDeletedEvent ev = new AusbildungDeletedEvent(key, details);
		ev.entityFound = true;
		ev.deletionCompleted = false;
		return ev;
	}

	public static AusbildungDeletedEvent notFound(String key) {
		AusbildungDeletedEvent ev = new AusbildungDeletedEvent(key);
		ev.entityFound = false;
		return ev;
	}
}
