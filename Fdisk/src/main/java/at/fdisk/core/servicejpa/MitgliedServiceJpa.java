package at.fdisk.core.servicejpa;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.domain.Ausruestung;
import at.fdisk.core.domain.Feuerwehr;
import at.fdisk.core.domain.Mitglied;
import at.fdisk.core.repositoryjpa.MitgliedJpaRepository;



@Service
public class MitgliedServiceJpa {

	@Autowired
	private MitgliedJpaRepository mitgliedJpaRepository;
	
	public void createNewMitglied(String vorname, String nachname, String dienstgrad,
			Date geburtsdatum, String wohnort, Feuerwehr feuerwehr,
			Collection<Ausruestung> ausruestungen, Collection<Ausbildung> ausbildung){
		Mitglied mitglied = new Mitglied(vorname, nachname, dienstgrad, geburtsdatum,
				wohnort, feuerwehr, ausruestungen, ausbildung);
		mitgliedJpaRepository.persist(mitglied);
	}
	
	public void setMitgliedJpaReposiotry (MitgliedJpaRepository mitgliedJpaRepository){
		this.mitgliedJpaRepository = mitgliedJpaRepository;
	}
}
