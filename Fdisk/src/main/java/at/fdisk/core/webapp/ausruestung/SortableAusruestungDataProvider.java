package at.fdisk.core.webapp.ausruestung;

import java.util.Iterator;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;

import at.fdisk.core.domain.Ausruestung;
import at.fdisk.core.webapp.DatabaseLocator;

public class SortableAusruestungDataProvider extends SortableDataProvider<Ausruestung, String>{
	
	public SortableAusruestungDataProvider(){
		setSort("bezeichnung", SortOrder.ASCENDING);
	}
	
	protected AusruestungDB getDB(){
		return DatabaseLocator.getAusruestungDatabase();
	}
	
	@Override
	public Iterator<? extends Ausruestung> iterator(long first, long count) {
		return getDB().find(first, count, getSort()).iterator();
	}

	@Override
	public long size() {
		return getDB().getCount();
	}

	@Override
	public IModel<Ausruestung> model(Ausruestung object) {
		return new DetachableAusruestungModel(object);
	}
}
