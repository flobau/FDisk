package at.fdisk.repository;

import java.util.Date;

import at.fdisk.domain.Ausruestung;
import at.fdisk.domain.Mitglied;
import at.fdisk.repository.AusruestungRepository;

import com.mysema.query.jpa.impl.JPAQuery;

import at.fdisk.domain.QAusruestung;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(classes = RepositoryTestConfiguration.class)
public class AusruestungQuerydslTest extends AbstractJUnit4SpringContextTests {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    AusruestungRepository ausruestungRepository;

    @Before
    public void setup() {
    	ausruestungRepository.deleteAll();
    }

    @Test
    public void testFindByName() {
        // given
    	ausruestungRepository.save(new Ausruestung("Handschuh", new Mitglied(), new Date()));
    	ausruestungRepository.save(new Ausruestung("Jacke", new Mitglied(), new Date()));
    	ausruestungRepository.save(new Ausruestung("Hose", new Mitglied(), new Date()));

        // when
        JPAQuery query = new JPAQuery(entityManager);
        QAusruestung ausruestung = QAusruestung.ausruestung;
        query.from(ausruestung).
                where(ausruestung.bezeichnung.eq("Jacke")).
                orderBy(ausruestung.ausgegeben.asc());

        Ausruestung result = query.singleResult(ausruestung);

        // then
        Assert.assertNotNull(result);
        Assert.assertEquals("Jacke", result.getBezeichnung());
    }
}
