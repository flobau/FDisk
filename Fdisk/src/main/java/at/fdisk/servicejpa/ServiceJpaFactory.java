/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Joachim Grüneis
 * mailto:grueneis@spengergasse.at
 */
package at.fdisk.servicejpa;

/**
 * Interface for the 'abstract factory' to be used for providing all services. This approach is required when not using
 * e.g. Spring.
 */
public interface ServiceJpaFactory {

    MitgliedServiceJpa mitgliedServiceJpa();
}