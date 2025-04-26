package org.gis.controller

import org.gis.props.KtlProps
import org.gis.service.MainBusinessService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/")
//@ComponentScan("org.gis.*")
class HealthCheckController(
    private val mainBusinessService: MainBusinessService
) {

    @Autowired
    private lateinit var ktlProps:  KtlProps


    @GetMapping("/hi")
    fun getHealthCheck(): ResponseEntity<List<String>> {
        return ResponseEntity.ok(mainBusinessService.getData("hi"));
    }
}

