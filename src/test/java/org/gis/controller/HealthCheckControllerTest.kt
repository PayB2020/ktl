package org.gis.controller

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.internals.FutureRecordMetadata
import org.gis.configuration.WebConfig
import org.gis.props.KtlProps
import org.gis.service.MainBusinessServiceImpl
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.mockito.kotlin.any
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.Import
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import javax.sql.DataSource

@WebMvcTest(HealthCheckController::class)
@MockBean(KtlProps::class, JdbcTemplate::class, DataSource::class)
@Import(HealthCheckController::class)
@ContextConfiguration(classes = [MainBusinessServiceImpl::class, WebConfig::class, HealthCheckController::class])
class HealthCheckControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean(name = "notifyStreamingKafkaProducer")
    private lateinit var kafkaProducer: KafkaProducer<String, String>

    @MockBean
    private lateinit var futureRecordMetadata: FutureRecordMetadata

    @Test
    fun `get health check`() {

        `when`(kafkaProducer.send(any())).thenReturn(futureRecordMetadata)
        `when`(futureRecordMetadata.get()).thenReturn(any());
        mockMvc.perform(MockMvcRequestBuilders.get("/hi"))
            .andExpect(status().isOk())
    }
}