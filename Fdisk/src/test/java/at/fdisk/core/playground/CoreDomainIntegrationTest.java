package at.fdisk.core.playground;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.rest.RestApplicationConfig;
import at.fdisk.core.service.FdiskManagementService;
import static junit.framework.TestCase.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RestApplicationConfig.class })
public class CoreDomainIntegrationTest {

	@Autowired
	FdiskManagementService fdiskManagementService;

	@Test
	public void thatAllMenuItemsReturned() {
		assertEquals(0, fdiskManagementService.getAllAusbildungen().size());
	}

	@Test
	public void addANewAusbildungToTheSystem() {

		Ausbildung ausbildung = new Ausbildung("Test", "T", new Date(), new Date());

		fdiskManagementService.createNewAusbildung(ausbildung.getBezeichnung(),
				ausbildung.getKurz_bezeichnung(), ausbildung.getStartdatum(),
				ausbildung.getEnddatum());

		assertEquals(1, fdiskManagementService.getAllAusbildungen().size());
	}

}
