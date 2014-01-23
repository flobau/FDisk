package at.fdisk.core.events.ausbildung;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AllAusbildungDetailEvent {

	private final List<AusbildungDetails> ausbildungen;

	public AllAusbildungDetailEvent(List<AusbildungDetails> ausbildungen) {
		this.ausbildungen = Collections.unmodifiableList(ausbildungen);
	}

	public Collection<AusbildungDetails> getOrdersDetails() {
		return this.ausbildungen;
	}

}
