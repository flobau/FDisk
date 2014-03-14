package at.fdisk.core.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.repository.AusbildungRepository;

@Service
public class FdiskManagementService {

	@Autowired
	private AusbildungRepository ausbildungRepository;

	@Transactional
	public void createNewAusbildung(String bezeichnung,
			String kurz_bezeichnung, Date startdatum, Date enddatum) {
		Ausbildung ausbildung = new Ausbildung(bezeichnung, kurz_bezeichnung,
				startdatum, enddatum);
		ausbildungRepository.save(ausbildung);
	}
	
	@Transactional
	public List<Ausbildung> getAllAusbildungen(){
		return ausbildungRepository.findAll();
	}
}
