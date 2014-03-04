package at.fdisk.core.servicejpa;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * A configuration providing all services - either through component scan of bean declaration.
 */
@Configuration
@ComponentScan(basePackageClasses = ServiceJpaPackage.class)
public class ServiceJpaConfiguration {}
