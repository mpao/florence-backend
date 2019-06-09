package io.github.mpao.florencebackend.controllers

import io.github.mpao.florencebackend.OPEN_EVENTS_URL
import io.github.mpao.florencebackend.PARKINGS_URL
import io.github.mpao.florencebackend.entities.Event
import io.github.mpao.florencebackend.entities.OpendataEvents
import io.github.mpao.florencebackend.entities.ParkingStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate
import reactor.core.publisher.Flux

@RestController
class OpenDataController {

    @Autowired lateinit var rest: RestTemplate

    @GetMapping( "/")
    @ResponseBody
    fun home(): String {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<body>\n" +
                "\t<ul>\n" +
                "\t\t<li><a href=\"/events\">Eventi</a></li>\n" +
                "\t\t<li><a href=\"/parkings\">Parkings</a></li>\n" +
                "\t</ul>\n" +
                "</body>\n" +
                "</html>"
    }

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