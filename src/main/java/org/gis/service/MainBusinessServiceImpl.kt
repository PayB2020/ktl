package org.gis.service

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import java.util.*

@Service
@Qualifier("MainBusinessServiceImpl")
class MainBusinessServiceImpl (
    private val jdbcTemplate: JdbcTemplate,
    @Qualifier("notifyStreamingKafkaProducer") private val notifyStreamingKafkaProducer: KafkaProducer<String, String>


) : MainBusinessService {
    override fun getData(id: String): List<String> {
        val recordLocal = ProducerRecord("gis", "1", id)
        val send = notifyStreamingKafkaProducer.send(recordLocal);
        send.get();
        val queryForObject = jdbcTemplate.queryForObject(CHECK_SHK_FOLDER, String::class.java, "oofm-bm")
        println(queryForObject);
        return Arrays.asList(queryForObject);
    }

    companion object {
        private const val CHECK_SHK_FOLDER = "select folder_id from shk_folder where folder_name = ?;"

    }
}