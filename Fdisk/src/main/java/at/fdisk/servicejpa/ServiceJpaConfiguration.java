/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Joachim Grüneis
 * mailto:grueneis@spengergasse.at
 */
package at.fdisk.servicejpa;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * A configuration providing all services - either through component scan of bean declaration.
 */
@Configuration
@ComponentScan(basePackageClasses = ServiceJpaPackage.class)
public class ServiceJpaConfiguration {}
