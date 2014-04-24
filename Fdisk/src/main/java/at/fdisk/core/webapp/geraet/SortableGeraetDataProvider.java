package at.fdisk.core.webapp.geraet;

import java.util.Iterator;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;

import at.fdisk.core.domain.Geraet;
import at.fdisk.core.webapp.DatabaseLocator;

public class SortableGeraetDataProvider extends SortableDataProvider<Geraet, String>{

	public SortableGeraetDataProvider(){
		setSort("typ", SortOrder.ASCENDING);
	}
	
	protected GeraetDB getDB(){
		return DatabaseLocator.getGeraetDatabase();
	}
	
	@Override
	public Iterator<? extends Geraet> iterator(long first, long count) {
		return getDB().find(first, count, getSort()).iterator();
	}

	@Override
	public long size() {
		return getDB().getCount();
	}

	@Override
	public IModel<Geraet> model(Geraet object) {
		return new DetachableGeraetModel(object);
	}
	
}