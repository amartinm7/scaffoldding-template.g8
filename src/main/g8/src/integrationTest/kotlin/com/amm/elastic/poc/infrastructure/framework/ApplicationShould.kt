package com.amm.elastic.poc.infrastructure.framework

import io.restassured.module.mockmvc.RestAssuredMockMvc
import org.hamcrest.Matchers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@AutoConfigureMockMvc
class ApplicationShould: SpringBootIntegration() {
    @Autowired
    private val mvc: MockMvc? = null

    @BeforeEach
    fun setUp() {
        RestAssuredMockMvc.mockMvc(mvc)
    }

    @Test
    fun `should be healthy`() {
        RestAssuredMockMvc.given()
            .`when`()["/actuator/health"]
            .then()
            .assertThat(MockMvcResultMatchers.status().isOk)
            .body("status", Matchers.equalTo("UP"))
    }

    @Test
    fun `should give info`() {
        RestAssuredMockMvc.given()
            .`when`()["/actuator/info"]
            .then()
            .assertThat(MockMvcResultMatchers.status().isOk)
    }

    @Test
    fun `should not expose shutdown endpoint`() {
        RestAssuredMockMvc.given()
            .`when`()["/actuator/shutdown"]
            .then()
            .assertThat(MockMvcResultMatchers.status().is4xxClientError)
    }
}
