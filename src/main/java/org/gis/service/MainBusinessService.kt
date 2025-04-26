package org.gis.service

import org.springframework.http.ResponseEntity

interface MainBusinessService {
    fun getData(id: String): List<String>
}