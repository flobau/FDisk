package at.fdisk.core.service;

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
	public void insertNewAusbildung(){
		Assert.assertNotNull(fdiskManagementService);
	}
}
