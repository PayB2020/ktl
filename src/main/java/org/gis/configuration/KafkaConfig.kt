package org.gis.configuration

import org.apache.kafka.clients.producer.KafkaProducer
import org.gis.props.KtlProps
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.listener.ContainerProperties

@Configuration
@EnableKafka
@EnableConfigurationProperties(KtlProps::class)
open class KafkaConfig {

    @Bean("notifyStreamingKafkaProducer")
    open fun notifyStreamingKafkaProducer(
        properties: KtlProps
    ): KafkaProducer<String, String> {
//        val props = null;
//        return KafkaProducer<String, String>(props);
        val props = properties.notify.kafka.buildProducerProperties()
        return KafkaProducer<String, String>(props)
    }

    @Bean("notifyStreamingConsumerFactory")
    open fun notifyStreamingConsumerFactory(
        properties: KtlProps
    ): ConsumerFactory<String, String> {
        val props = properties.notify.kafka.buildConsumerProperties()
        return DefaultKafkaConsumerFactory(props)
    }

    @Bean("notifyStreamingKafkaContainerFactory")
    open fun notifyStreamingKafkaContainerFactory(
        @Qualifier("notifyStreamingConsumerFactory")
        notifyStreamingConsumerFactory: ConsumerFactory<String, String>
    ): ConcurrentKafkaListenerContainerFactory<String, String> {
        val containerFactory = ConcurrentKafkaListenerContainerFactory<String, String>()
        containerFactory.consumerFactory = notifyStreamingConsumerFactory
        containerFactory.containerProperties.ackMode = ContainerProperties.AckMode.MANUAL
        return containerFactory
    }
}