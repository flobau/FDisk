package at.fdisk.app;

import java.util.HashMap;

import at.fdisk.repositoryjpa.PersistenceFactory;
import at.fdisk.service.MitgliedService;
import at.fdisk.service.Service;
import at.fdisk.service.ServiceFactory;


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
