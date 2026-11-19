package ch.bbw.architecturerefcard01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Unit-Test fuer den REST-Endpunkt /api (nur Web-Layer, ohne echten Server).
 */
@WebMvcTest(RestAPIController.class)
class RestAPIControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void apiLiefertJsonMitBegruessung() throws Exception {
        mockMvc.perform(get("/api"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.text", startsWith("Application Ref. Card 01 - API hello")));
    }
}
