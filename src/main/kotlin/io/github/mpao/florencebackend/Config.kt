package io.github.mpao.florencebackend

import org.springframework.boot.runApplication

const val OPEN_EVENTS_URL = "http://wwwext.comune.fi.it/opendata/files/eventi.json"
const val PARKINGS_URL    = "http://opendata.comune.fi.it/od/ParkFreeSpot.json"

fun main(args: Array<String>) {
    runApplication<App>(*args)
}