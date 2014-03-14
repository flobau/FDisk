package at.fdisk.core.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import at.fdisk.core.service.FdiskManagementService;
import at.fdisk.core.web.controller.SiteController;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SiteIntegrationTest {

    private static final String RESPONSE_BODY = "";

    MockMvc mockMvc;

    @InjectMocks
    SiteController controller = new SiteController();

    @Mock
    FdiskManagementService fdiskManagementService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(controller).build();
    }

    @Test
    public void thatTextReturned() throws Exception {
        mockMvc.perform(get("/"))
        .andDo(print())
        .andExpect(content().string(RESPONSE_BODY));

    }

}