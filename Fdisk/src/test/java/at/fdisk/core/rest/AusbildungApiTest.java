package at.fdisk.core.rest;

import org.junit.Before;
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
@WebAppConfiguration
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = at.fdisk.core.rest.RestApplicationConfig.class)
public class AusbildungApiTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	public void insertNewAusbildung() throws Exception {
		mockMvc.perform(
				post("/ausbildungen")
						.contentType(MediaType.APPLICATION_JSON)
						.content(
								"{\"startdatum\":\"2014-01-01\", \"kurzBezeichnung\":\"AS\", \"bezeichnung\":\"Atemschutz\", \"enddatum\":\"2014-01-02\"}"))
				.andExpect(status().isCreated());
	}

	@Test
	public void readFromEmptyListOfAusbildungen() throws Exception {
		mockMvc.perform(get("/ausbildungen")).andExpect(status().isOk());
	}
}
