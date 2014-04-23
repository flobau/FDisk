package at.fdisk.core.webapp.feuerwehrauto;

import org.apache.wicket.model.LoadableDetachableModel;

import at.fdisk.core.domain.Feuerwehrauto;
import at.fdisk.core.webapp.DatabaseLocator;

public class DetachableFeuerwehrautoModel extends LoadableDetachableModel<Feuerwehrauto>{
	private final int key;

	protected FeuerwehrautoDB getFeuerwehrautoDB() {
		return DatabaseLocator.getFeuerwehrautoDatabase();
	}

	public DetachableFeuerwehrautoModel(Feuerwehrauto a) {
		this(a.getKey());
	}

	public DetachableFeuerwehrautoModel(int key) {
		if (key == 0) {
			throw new IllegalArgumentException();
		}
		this.key = key;
	}

	@Override
	protected Feuerwehrauto load() {
		return getFeuerwehrautoDB().get(key);
	}
}
