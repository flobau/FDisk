package at.fdisk.core.service;

import at.fdisk.core.domain.DomainConfiguration;
import at.fdisk.core.repository.RepositoryConfiguration;
import at.fdisk.core.repositoryjpa.RepositoryJpaConfiguration;
import at.fdisk.core.servicejpa.ServiceJpaConfiguration;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * To combine all configurations from main that are required to execute test on layer of service. Additionally H2
 * database is used as datasource at testing.
 */
@Configuration
@Import({DomainConfiguration.class, RepositoryConfiguration.class, ServiceConfiguration.class})
public class ServiceTestConfiguration {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
    }
}