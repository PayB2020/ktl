package org.gis.service

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.stereotype.Service

@Service
class NotifyListener {

    @KafkaListener(
        topics = ["gis"],
        containerFactory = "notifyStreamingKafkaContainerFactory",
        id = "notify-streaming-kafka-listener",
        groupId = "notify-streaming-consumers-group"
    )
     fun onMessage(data: ConsumerRecord<String, String>, acknowledgment: Acknowledgment?) {
        println(data.value())
    }
}