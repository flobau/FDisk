package at.fdisk.core.rest;

import javax.annotation.Resource;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RestApplicationConfig.class)
@WebAppConfiguration
public class AusbildungApiTest {
	@Resource
    private WebApplicationContext webApplicationContext;

    @Ignore
    @Test
    public void firstTry() throws Exception {

        MockMvc mockMvc = webAppContextSetup(webApplicationContext).build();

        mockMvc.perform(get("/ausbildung")).andExpect(status().isOk());
        System.out.println("GFÜ");
    }
}
