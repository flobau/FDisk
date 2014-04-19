package at.fdisk.core.webapp.ausbildung;

import java.util.Date;

import org.apache.wicket.model.LoadableDetachableModel;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.webapp.DatabaseLocator;

public class DetachableAusbildungModel extends LoadableDetachableModel<Ausbildung>{
	
	private final int key;
	
	protected AusbildungDB getAusbildungDB()
	{
		return DatabaseLocator.getAusbildungDatabase();
	}
	
	public DetachableAusbildungModel(Ausbildung a){
		this(a.getKey());
	}
	
	public DetachableAusbildungModel(int key){
		if(key == 0){
			throw new IllegalArgumentException();
		}
		this.key = key;
	}
	
	@Override
	protected Ausbildung load() {
		return getAusbildungDB().get(key);
	}

}
