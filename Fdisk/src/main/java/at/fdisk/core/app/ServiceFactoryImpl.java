package at.fdisk.core.app;

import java.util.HashMap;

import at.fdisk.core.repositoryjpa.PersistenceFactory;
import at.fdisk.core.service.MitgliedService;
import at.fdisk.core.service.Service;
import at.fdisk.core.service.ServiceFactory;


public class ServiceFactoryImpl implements ServiceFactory {

	private final HashMap<Class<?>, Service> services = new HashMap<>();
	private PersistenceFactory persistenceFactory;

	public ServiceFactoryImpl(PersistenceFactory persistenceFactory) {
		this.persistenceFactory = persistenceFactory;
	}

	@Override
	public MitgliedService mitgliedService() {
		return new MitgliedService();
	}

}
