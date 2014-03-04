package at.fdisk.core.app;

import java.util.HashMap;

import at.fdisk.core.repositoryjpa.PersistenceFactory;
import at.fdisk.core.servicejpa.MitgliedServiceJpa;
import at.fdisk.core.servicejpa.ServiceJpa;
import at.fdisk.core.servicejpa.ServiceJpaFactory;


public class ServiceFactoryImpl implements ServiceJpaFactory {

	private final HashMap<Class<?>, ServiceJpa> services = new HashMap<>();
	private PersistenceFactory persistenceFactory;

	public ServiceFactoryImpl(PersistenceFactory persistenceFactory) {
		this.persistenceFactory = persistenceFactory;
	}

	@Override
	public MitgliedServiceJpa mitgliedServiceJpa() {
		// TODO Auto-generated method stub
		return null;
	}

}
