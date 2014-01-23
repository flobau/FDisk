package at.fdisk.core.events.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import at.fdisk.core.domain.Ausbildung;

public class AllAusbildungEvent {

	private final List<Ausbildung> ausbildungen;

	public AllAusbildungEvent(List<Ausbildung> orders) {
		this.ausbildungen = Collections.unmodifiableList(orders);
	}

	public Collection<Ausbildung> getOrdersDetails() {
		return this.ausbildungen;
	}

}
