package io.github.mpao.florencebackend.entities

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_EMPTY)
data class ParkingStatus(
        @JsonProperty("Id") var id: Int,
        @JsonProperty("Name") var name: String,
        @JsonProperty("FreeSpot") var freeSpot:Int,
        @JsonProperty("UpdateDate") var updateDate: String,
        @JsonProperty("Latitude") var latitude: Double,
        @JsonProperty("Longitude") var longitude: Double
)