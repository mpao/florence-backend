package io.github.mpao.florencebackend

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping(path=["/florence-app-resources"], produces=["application/json"])
@CrossOrigin
class OpenDataController {

    @Autowired lateinit var rest: RestTemplate

    @GetMapping("/opendata-events")
    fun getEvents(): String? = rest.getForObject(OPEN_EVENTS_URL, String::class.java)

    @GetMapping("/opendata-parkings")
    fun getParkings(): String? = rest.getForObject(PARKINGS_URL, String::class.java)

}