package at.fdisk.core.webapp.mitglied;

import java.util.Iterator;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;

import at.fdisk.core.domain.Mitglied;
import at.fdisk.core.webapp.DatabaseLocator;

public class SortableMitgliedDataProvider extends SortableDataProvider<Mitglied, String>{

	public SortableMitgliedDataProvider(){
		setSort("typ", SortOrder.ASCENDING);
	}
	
	protected MitgliedDB getDB(){
		return DatabaseLocator.getMitgliedDatabase();
	}
	
	@Override
	public Iterator<? extends Mitglied> iterator(long first, long count) {
		return getDB().find(first, count, getSort()).iterator();
	}

	@Override
	public long size() {
		return getDB().getCount();
	}

	@Override
	public IModel<Mitglied> model(Mitglied object) {
		return new DetachableMitgliedModel(object);
	}
	
}