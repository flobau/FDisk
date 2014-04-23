package at.fdisk.core.webapp.feuerwehrauto;

import java.util.Iterator;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;

import at.fdisk.core.domain.Feuerwehrauto;
import at.fdisk.core.webapp.DatabaseLocator;

public class SortableFeuerwehrautoDataProvider extends SortableDataProvider<Feuerwehrauto, String>{

	public SortableFeuerwehrautoDataProvider(){
		setSort("typ", SortOrder.ASCENDING);
	}
	
	protected FeuerwehrautoDB getDB(){
		return DatabaseLocator.getFeuerwehrautoDatabase();
	}
	
	@Override
	public Iterator<? extends Feuerwehrauto> iterator(long first, long count) {
		return getDB().find(first, count, getSort()).iterator();
	}

	@Override
	public long size() {
		return getDB().getCount();
	}

	@Override
	public IModel<Feuerwehrauto> model(Feuerwehrauto object) {
		return new DetachableFeuerwehrautoModel(object);
	}
	
}
