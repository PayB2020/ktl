package org.gis.controller

import org.gis.props.KtlProps
import org.gis.service.MainBusinessService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(HealthCheckController::class)
//@ComponentScan("org.gis")
class HealthCheckControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc


    @MockBean
    private lateinit var mainBusinessService: MainBusinessService

    @MockBean
    private lateinit var ktlProps: KtlProps


    @Test
    fun myTest() {
        mockMvc.perform(MockMvcRequestBuilders.post("/hi")).andExpect(status().isMethodNotAllowed())
    }
}