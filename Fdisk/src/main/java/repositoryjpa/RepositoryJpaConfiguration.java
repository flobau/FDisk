package repositoryjpa;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring configuration to introduce pure JPA repositories.
 */
@Configuration
@ComponentScan(basePackageClasses = RepositoryJpaPackage.class)
public class RepositoryJpaConfiguration {
}