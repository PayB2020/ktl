package org.gis.props

import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.context.properties.bind.ConstructorBinding
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration


//@ConstructorBinding
@ConfigurationProperties("ktl")
data class KtlProps (
    val notify: NotifyProps,
    val  enabled: Boolean
//)
)

data class NotifyProps(
    val kafka: KafkaProperties,
    val enabled: Boolean
)

