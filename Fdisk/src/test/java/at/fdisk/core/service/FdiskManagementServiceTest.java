package at.fdisk.core.service;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;


@ContextConfiguration(classes = ServiceTestConfiguration.class)
public class FdiskManagementServiceTest extends AbstractJUnit4SpringContextTests {

	@Autowired
	FdiskManagementService fdiskManagementService;
	
	@Test
	public void aTest(){
		Assert.assertNotNull(fdiskManagementService);
	}

	public void findNothing(){
		Assert.assertEquals(0, fdiskManagementService.getAllAusbildungen().size());
	}
	
	public void findOneAusbildung(){
		fdiskManagementService.createNewAusbildung("LOL", "L", new Date(), new Date());
		Assert.assertEquals(1, fdiskManagementService.getAllAusbildungen().size());
	}
}
