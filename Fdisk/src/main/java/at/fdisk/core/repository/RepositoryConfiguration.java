package at.fdisk.core.repository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
@ComponentScan(basePackageClasses = RepositoryPackage.class)
public class RepositoryConfiguration {
}