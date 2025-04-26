package org.gis

import org.gis.props.KtlProps
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.scheduling.annotation.EnableScheduling


@SpringBootApplication
//@EnableScheduling
//@ComponentScan("org.gis.*")
@ConfigurationPropertiesScan
open class Starter

fun main(args: Array<String>) {
//    SpringApplication.run(Starter::class.java, *args)
    runApplication<Starter>(*args)
}

