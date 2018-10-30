package io.github.mpao.florencebackend.entities

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.mongodb.core.mapping.Document

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Document(collection = "parkingspots")
data class ParkingStatus(
        @JsonProperty("Id") var id: Int,
        @JsonProperty("Name") var name: String,
        @JsonProperty("FreeSpot") var freeSpot:Int,
        @JsonProperty("UpdateDate") var updateDate: String,
        @JsonProperty("Latitude") var latitude: Double,
        @JsonProperty("Longitude") var longitude: Double
)