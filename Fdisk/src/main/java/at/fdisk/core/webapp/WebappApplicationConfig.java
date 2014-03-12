package at.fdisk.core.webapp;

import at.fdisk.core.domain.DomainConfiguration;
import at.fdisk.core.repository.RepositoryConfiguration;
import at.fdisk.core.rest.RestPackage;
import at.fdisk.core.service.ServiceConfiguration;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Import(value = { DomainConfiguration.class, RepositoryConfiguration.class,
		ServiceConfiguration.class })
@Configuration
public class WebappApplicationConfig {

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				.build();
	}
}
