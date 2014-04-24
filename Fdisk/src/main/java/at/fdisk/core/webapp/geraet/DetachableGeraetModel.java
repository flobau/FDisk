package at.fdisk.core.webapp.geraet;

import org.apache.wicket.model.LoadableDetachableModel;

import at.fdisk.core.domain.Geraet;
import at.fdisk.core.webapp.DatabaseLocator;

public class DetachableGeraetModel extends LoadableDetachableModel<Geraet>{
	private final int key;

	protected GeraetDB getGeraetDB() {
		return DatabaseLocator.getGeraetDatabase();
	}

	public DetachableGeraetModel(Geraet a) {
		this(a.getKey());
	}

	public DetachableGeraetModel(int key) {
		if (key == 0) {
			throw new IllegalArgumentException();
		}
		this.key = key;
	}

	@Override
	protected Geraet load() {
		return getGeraetDB().get(key);
	}
}
