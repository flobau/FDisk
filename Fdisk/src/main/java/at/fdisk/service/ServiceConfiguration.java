package at.fdisk.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = ServicePackage.class)
public class ServiceConfiguration {}
