package ch.bbw.architecturerefcard01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Integrationstest: startet die ganze App auf einem zufaelligen Port
 * und ruft die Endpunkte ueber echtes HTTP auf.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ArchitectureRefCard01ApplicationIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void apiIstErreichbar() {
        ResponseEntity<Message> response = restTemplate.getForEntity("/api", Message.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getText()).startsWith("Application Ref. Card 01 - API hello");
    }

    @Test
    void startseiteIstErreichbar() {
        ResponseEntity<String> response = restTemplate.getForEntity("/", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).contains("Application Ref. Card 01");
    }
}
