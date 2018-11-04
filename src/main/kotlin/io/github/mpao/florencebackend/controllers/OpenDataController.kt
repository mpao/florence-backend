package io.github.mpao.florencebackend.controllers

import io.github.mpao.florencebackend.OPEN_EVENTS_URL
import io.github.mpao.florencebackend.PARKINGS_URL
import io.github.mpao.florencebackend.entities.Event
import io.github.mpao.florencebackend.entities.OpendataEvents
import io.github.mpao.florencebackend.entities.ParkingStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import reactor.core.publisher.Flux

@RestController
@RequestMapping(path=["/florence-app-resources"], produces=["application/json"])
@CrossOrigin
class OpenDataController {

    @Autowired lateinit var rest: RestTemplate

    @GetMapping( "/events", produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun getEvents(): Flux<Event> {

        val data: OpendataEvents = rest.getForObject(OPEN_EVENTS_URL, OpendataEvents::class.java) ?: OpendataEvents(arrayListOf())
        return Flux.fromIterable(data.eventi)

    }


    @GetMapping( "/parkings", produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun getParkings(): Flux<ParkingStatus> {

        val data: Array<ParkingStatus> = rest.getForObject(PARKINGS_URL, Array<ParkingStatus>::class.java) ?: arrayOf()
        return Flux.fromArray(data)

    }

}