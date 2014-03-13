package at.fdisk.core.rest;

import at.fdisk.core.domain.DomainConfiguration;
import at.fdisk.core.repository.RepositoryConfiguration;
import at.fdisk.core.service.ServiceConfiguration;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@Import(value = { DomainConfiguration.class, RepositoryConfiguration.class,
		ServiceConfiguration.class })
@ComponentScan(basePackageClasses = RestPackage.class)
public class RestApplicationConfig {

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				.build();
	}
}