package at.fdisk.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import at.fdisk.core.service.FdiskManagementService;

@Configuration
public class CoreConfig {
	@Bean
	public FdiskManagementService fdsikManagementService() {
		return new FdiskManagementService();
	}
}
