package at.fdisk.core.config;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.domain.Feuerwehr;
import at.fdisk.core.repository.AusbildungRepository;
import at.fdisk.core.repository.impl.AusbildungRepositoryImpl;
import at.fdisk.core.service.FdiskManagementService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class PersistenceConfig {

	@Bean
	public AusbildungRepository ausbildungRepo() {
		return (AusbildungRepository) new AusbildungRepositoryImpl();
	}

	@Bean
	public FdiskManagementService fdiskManagementService() {
		return new FdiskManagementService();
	}

	private Map<String, Ausbildung> defaultMenu() {
		Map<String, Ausbildung> items = new HashMap<String, Ausbildung>();
		items.put("Au1", new Ausbildung("Ausbildung1", "Au1", new Feuerwehr(), new Date(), new Date()));
		items.put("Au2", new Ausbildung("Ausbildung2", "Au2", new Feuerwehr(), new Date(), new Date()));
		items.put("Au3", new Ausbildung("Ausbildung3", "Au3", new Feuerwehr(), new Date(), new Date()));
		return items;
	}
}