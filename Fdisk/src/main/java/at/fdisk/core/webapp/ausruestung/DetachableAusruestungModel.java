package at.fdisk.core.webapp.ausruestung;

import org.apache.wicket.model.LoadableDetachableModel;

import at.fdisk.core.domain.Ausruestung;
import at.fdisk.core.webapp.DatabaseLocator;

public class DetachableAusruestungModel extends LoadableDetachableModel<Ausruestung>{
	private final int key;

	protected AusruestungDB getAusruestungDB() {
		return DatabaseLocator.getAusruestungDatabase();
	}

	public DetachableAusruestungModel(Ausruestung a) {
		this(a.getKey());
	}

	public DetachableAusruestungModel(int key) {
		if (key == 0) {
			throw new IllegalArgumentException();
		}
		this.key = key;
	}

	@Override
	protected Ausruestung load() {
		return getAusruestungDB().get(key);
	}
}
