package at.fdisk.core.repository.impl;

import at.fdisk.core.domain.Ausbildung;
import at.fdisk.core.domain.Feuerwehr;
import at.fdisk.core.repository.AusbildungRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.util.Date;

@ContextConfiguration(classes = RepositoryTestConfiguration.class)
public class AusbildungRepositoryImplTest extends
        AbstractJUnit4SpringContextTests {

    @Autowired
    private AusbildungRepository ausbildungRepository;

    @Before
    public void setup() {
        logger.error("AusbildungRepositoryImplTest.setup");
        ausbildungRepository.deleteAll();
    }

    @Test
    public void testFindByBezeichnung() {
        logger.error("AusbildungRepositoryImplTest.testFindByBezeichnung");
        Ausbildung a1 = new Ausbildung("TEST1", "T1", new Feuerwehr(),
                new Date(), new Date());
        Ausbildung a2 = new Ausbildung("TEST2", "T2", new Feuerwehr(),
                new Date(), new Date());
        Ausbildung a3 = new Ausbildung("TEST3", "T3", new Feuerwehr(),
                new Date(), new Date());
        ausbildungRepository.save(a1);
        ausbildungRepository.save(a2);
        ausbildungRepository.save(a3);
        Ausbildung ausbildung = ausbildungRepository.findByBezeichnung(a1
                .getBezeichnung());

        Assert.assertNotNull(ausbildung);
        Assert.assertEquals(ausbildung, a1);
    }

    @Test
    public void testFindByKurzbezeichnung() {
        logger.error("AusbildungRepositoryImplTest.testFindByKurzbezeichnung");
        Ausbildung a1 = new Ausbildung("TEST1", "T1", new Feuerwehr(),
                new Date(), new Date());
        Ausbildung a2 = new Ausbildung("TEST2", "T2", new Feuerwehr(),
                new Date(), new Date());
        Ausbildung a3 = new Ausbildung("TEST3", "T3", new Feuerwehr(),
                new Date(), new Date());
        ausbildungRepository.save(a1);
        ausbildungRepository.save(a2);
        ausbildungRepository.save(a3);
        Ausbildung ausbildung = ausbildungRepository.findByKurzbezeichnung(a2
                .getKurz_bezeichnung());

        Assert.assertNotNull(ausbildung);
        Assert.assertEquals(ausbildung, a2);
    }
}
