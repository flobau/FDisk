package at.fdisk.servicejpa;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import at.fdisk.domain.DomainConfiguration;
import at.fdisk.repositoryjpa.RepositoryJpaConfiguration;
import at.fdisk.servicejpa.ServiceJpaConfiguration;

@Configuration
@Import({ DomainConfiguration.class, RepositoryJpaConfiguration.class,
		ServiceJpaConfiguration.class })
public class ServiceTestConfiguration {

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
				.build();
	}
}
