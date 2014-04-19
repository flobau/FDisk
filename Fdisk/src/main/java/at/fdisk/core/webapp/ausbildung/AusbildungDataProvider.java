package at.fdisk.core.webapp.ausbildung;

import java.util.Iterator;

import org.apache.wicket.extensions.markup.html.repeater.util.SortParam;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.webapp.DatabaseLocator;

public class AusbildungDataProvider implements IDataProvider<Ausbildung>{
	
	protected AusbildungDB getDB(){
		return DatabaseLocator.getAusbildungDatabase();
	}
	
	@Override
	public IModel<Ausbildung> model(Ausbildung object) {
		return new DetachableAusbildungModel(object);
	}

	@Override
	public void detach() {	
	}

	@Override
	public Iterator<? extends Ausbildung> iterator(long first, long count) {
		return getDB().find(first, count, new SortParam<String>("firstName", true))
				.iterator();
	}

	@Override
	public long size() {
		return getDB().getCount();
	}

}
