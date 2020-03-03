package info.novatec.decoding.example

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient

@WebFluxTest(Controller::class)
internal class ControllerTests(
    @Autowired private val webTestClient: WebTestClient
) {
    @Test
    fun `responds with HTTP 400 BAD_REQUEST for missing foo in payload`() {
        webTestClient.post()
            .uri("/hello")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(""" { "bar": "bar text" } """)
            .exchange()
            .expectStatus().isBadRequest
    }
}
