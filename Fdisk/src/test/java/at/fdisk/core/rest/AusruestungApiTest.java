package at.fdisk.core.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = RestApplicationConfig.class)
@WebAppConfiguration
public class AusruestungApiTest {

	@Resource
	private WebApplicationContext webApplicationContext;

	@Test
	public void readFromEmptyListOfAusruestungen() throws Exception {

		MockMvc mockMvc = webAppContextSetup(webApplicationContext).build();

		mockMvc.perform(get("/ausruestungen")).andExpect(status().isOk());
	}

	@Test
	public void insertNewAusruestung() throws Exception {

		MockMvc mockMvc = webAppContextSetup(webApplicationContext).build();

		mockMvc.perform(
				post("/ausruestungen")
						.contentType(MediaType.APPLICATION_JSON)
						.content(
								"{\"bezeichnung\":\"Handschuh\", \"benutzer\":\"\", \"ausgegeben\":\"2014-01-02\"}"))
				.andExpect(status().isCreated());
	}
}
