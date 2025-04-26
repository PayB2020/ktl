package org.gis.configuration

import org.gis.props.KtlProps
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(
    KtlProps::class,
)
open class WebConfig {

}
