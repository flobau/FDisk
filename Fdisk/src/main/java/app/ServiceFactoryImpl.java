package app;

import java.util.HashMap;

import repositoryjpa.PersistenceFactory;
import service.MitgliedService;
import service.Service;
import service.ServiceFactory;

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
