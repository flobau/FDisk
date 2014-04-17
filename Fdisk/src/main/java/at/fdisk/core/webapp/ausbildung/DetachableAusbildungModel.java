package at.fdisk.core.webapp.ausbildung;

import java.util.Date;

import org.apache.wicket.model.LoadableDetachableModel;

import at.fdisk.core.domain.Ausbildung;

public class DetachableAusbildungModel extends LoadableDetachableModel<Ausbildung>{
	
	private final int key;
	
	protected AusbildungDB getContactsDB()
	{
		return DatabaseLocator.getDatabase();
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
		return getContactsDB().get(key);
	}

}
