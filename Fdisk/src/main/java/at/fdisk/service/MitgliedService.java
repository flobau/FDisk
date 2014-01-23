package at.fdisk.service;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.fdisk.domain.Ausbildung;
import at.fdisk.domain.Ausruestung;
import at.fdisk.domain.Feuerwehr;
import at.fdisk.domain.Mitglied;
import at.fdisk.repository.MitgliedRepository;

@Service
public class MitgliedService {

	@Autowired
	private MitgliedRepository mitgliedRepository;

	public void createNewMitglied(String vorname, String nachname,
			String dienstgrad, Date geburtsdatum, String wohnort,
			Feuerwehr feuerwehr, Collection<Ausruestung> ausruestungen,
			Collection<Ausbildung> ausbildung) {
		Mitglied mitglied = new Mitglied(vorname, nachname, dienstgrad,
				geburtsdatum, wohnort, feuerwehr, ausruestungen, ausbildung);
		mitgliedRepository.save(mitglied);

	}
}
