package at.fdisk.core.webapp.mitglied;

import org.apache.wicket.model.LoadableDetachableModel;

import at.fdisk.core.domain.Mitglied;
import at.fdisk.core.webapp.DatabaseLocator;

public class DetachableMitgliedModel extends LoadableDetachableModel<Mitglied>{
	private final int key;

	protected MitgliedDB getGeraetDB() {
		return DatabaseLocator.getMitgliedDatabase();
	}

	public DetachableMitgliedModel(Mitglied a) {
		this(a.getKey());
	}

	public DetachableMitgliedModel(int key) {
		if (key == 0) {
			throw new IllegalArgumentException();
		}
		this.key = key;
	}

	@Override
	protected Mitglied load() {
		return getGeraetDB().get(key);
	}
}
