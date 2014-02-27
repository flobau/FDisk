package at.fdisk.core.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.domain.Ausruestung;
import at.fdisk.core.domain.Berechtigung;
import at.fdisk.core.domain.Charge;
import at.fdisk.core.domain.Feuerwehr;
import at.fdisk.core.domain.Mitglied;
import at.fdisk.core.repository.AusbildungRepository;
import at.fdisk.core.repository.AusruestungRepository;
import at.fdisk.core.repository.BerechtigungRepository;
import at.fdisk.core.repository.ChargeRepository;
import at.fdisk.core.repository.FeuerwehrRepository;

@Service
public class FdiskManagmentService {

	@Autowired
	private AusbildungRepository ausbildungRepository;
	@Autowired
	private AusruestungRepository ausruestungRepository;
	@Autowired
	private BerechtigungRepository berechtigungRepository;
	@Autowired
	private ChargeRepository chargeRepository;
	@Autowired
	private FeuerwehrRepository feuerwehrRepository;

	public void createNewAusbildung(String bezeichnung,
			String kurz_bezeichnung, Date startdatum, Date enddatum) {
		Ausbildung ausbildung = new Ausbildung(bezeichnung, kurz_bezeichnung,
				startdatum, enddatum);
		ausbildungRepository.save(ausbildung);
	}

	public void createNewAusruestung(String bezeichnung, Date ausgegeben) {
		Ausruestung ausruestung = new Ausruestung(bezeichnung, ausgegeben);
		ausruestungRepository.save(ausruestung);
	}
	
	public void createNewBerechtigung(String berechtigungName){
		Berechtigung berechtigung = new Berechtigung(berechtigungName);
		berechtigungRepository.save(berechtigung);
	}

	public void createNewCharge(String vorname, String nachname,
			String dienstgrad, Date geburtsdatum, String wohnort,
			String fachgebiet) {
		Charge charge = new Charge(vorname, nachname, dienstgrad, geburtsdatum,
				wohnort, fachgebiet);
		chargeRepository.save(charge);
	}
	
	public void createNewFeuerwehr(String ort){
		Feuerwehr feuerwehr = new Feuerwehr(ort);
		feuerwehrRepository.save(feuerwehr);
	}
}
