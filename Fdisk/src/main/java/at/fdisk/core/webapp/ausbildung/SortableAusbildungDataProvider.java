package at.fdisk.core.webapp.ausbildung;

import java.util.Iterator;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;

import at.fdisk.core.domain.Ausbildung;

public class SortableAusbildungDataProvider extends SortableDataProvider<Ausbildung, String>{

	public SortableAusbildungDataProvider()
	{
		// set default sort
		setSort("bezeichnung", SortOrder.ASCENDING);
	}
	
	protected AusbildungDB getDB()
	{
		return DatabaseLocator.getDatabase();
	}
	
	@Override
	public Iterator<? extends Ausbildung> iterator(long first, long count) {
		return getDB().find(first, count, getSort()).iterator();
	}

	@Override
	public long size() {
		return getDB().getCount();
	}

	@Override
	public IModel<Ausbildung> model(Ausbildung object) {
		return new DetachableAusbildungModel(object);
	}

}
