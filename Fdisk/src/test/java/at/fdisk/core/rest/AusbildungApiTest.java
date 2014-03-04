package at.fdisk.core.rest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = RestApplicationConfig.class)
@WebAppConfiguration
public class AusbildungApiTest {
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Test
	public void readFromEmptyListOfAusbildungen() throws Exception {

		MockMvc mockMvc = webAppContextSetup(webApplicationContext).build();

		mockMvc.perform(get("/ausbildungen")).andExpect(status().isOk());
	}

	@Test
	public void insertNewAusbildung() throws Exception {

		MockMvc mockMvc = webAppContextSetup(webApplicationContext).build();

		mockMvc.perform(
				post("/ausbildungen")
						.contentType(MediaType.APPLICATION_JSON)
						.content(
								"{\"startdatum\":\"2014-01-01\", \"kurzBezeichnung\":\"AS\", \"bezeichnung\":\"Atemschutz\", \"enddatum\":\"2014-01-02\"}"))
				.andExpect(status().isCreated());
	}
}
