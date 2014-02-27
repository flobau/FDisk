package at.fdisk.core.service;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.domain.Ausruestung;
import at.fdisk.core.domain.Feuerwehr;
import at.fdisk.core.domain.Mitglied;
import at.fdisk.core.repository.AusbildungRepository;
import at.fdisk.core.repository.MitgliedRepository;

@Service
public class FdiskManagmentService {

	@Autowired
	private MitgliedRepository mitgliedRepository;
	
	@Autowired
	private AusbildungRepository ausbildungRepository;

	public void createNewMitglied(String vorname, String nachname,
			String dienstgrad, Date geburtsdatum, String wohnort,
			Feuerwehr feuerwehr, Collection<Ausruestung> ausruestungen,
			Collection<Ausbildung> ausbildung) {
		Mitglied mitglied = new Mitglied(vorname, nachname, dienstgrad,
				geburtsdatum, wohnort, feuerwehr, ausruestungen, ausbildung);
		mitgliedRepository.save(mitglied);

	}

	public void createNewAusbildung(String bezeichnung,
			String kurz_bezeichnung, Date startdatum, Date enddatum) {
		Ausbildung ausbildung = new Ausbildung(bezeichnung, kurz_bezeichnung, startdatum, enddatum);
		ausbildungRepository.save(ausbildung);
	}
}
