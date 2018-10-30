package io.github.mpao.florencebackend.entities

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.data.mongodb.core.mapping.Document

/**
 * Descrive un evento degli Opendata del Comune di Firenze
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(
        "nome",
        "rilevanza",
        "informazioni",
        "repliche",
        "descrizioneInglese",
        "dataFine",
        "id_evento",
        "icona",
        "informazioniInglese",
        "url",
        "ordinamento",
        "descrizione",
        "categorie",
        "nomeInglese",
        "dataInizio"
)
@Document(collection = "events")
data class Event (
    @JsonProperty("nome") var nome: String?,
    @JsonProperty("rilevanza") var rilevanza: String?,
    @JsonProperty("informazioni") var informazioni: String?,
    @JsonProperty("repliche") var repliche: List<Repliche>?,
    @JsonProperty("descrizioneInglese") var descrizioneInglese: String?,
    @JsonProperty("dataFine") var dataFine: String?,
    @JsonProperty("id_evento") var idEvento: String?,
    @JsonProperty("icona") var icona: Any?,
    @JsonProperty("informazioniInglese") var informazioniInglese: String?,
    @JsonProperty("url") var url: List<String>?,
    @JsonProperty("ordinamento") var ordinamento: Int?,
    @JsonProperty("descrizione") var descrizione: String?,
    @JsonProperty("categorie") var categorie: List<Categorie>?,
    @JsonProperty("nomeInglese") var nomeInglese: String?,
    @JsonProperty("dataInizio") var dataInizio: String?
)

/**
 * Classe per completare Event
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(
        "nome",
        "rilevanza",
        "id_categoria",
        "nomeInglese"
)
data class Categorie (
    @JsonProperty("nome") var nome: String?,
    @JsonProperty("rilevanza") var rilevanza: String?,
    @JsonProperty("id_categoria") var idCategoria: String?,
    @JsonProperty("nomeInglese") var nomeInglese: String?
)

/**
 * Classe per completare Event
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(
        "prezzo",
        "gratuito",
        "longitudine",
        "id_replica",
        "recapito",
        "inizio",
        "orario_eng",
        "latitudine",
        "civico",
        "fine",
        "bambini",
        "orario_ita"
)
data class Repliche (
    @JsonProperty("prezzo") var prezzo: Any?,
    @JsonProperty("gratuito") var gratuito: String?,
    @JsonProperty("longitudine") var longitudine: String?,
    @JsonProperty("id_replica") var idReplica: String? ,
    @JsonProperty("recapito") var recapito: String?,
    @JsonProperty("inizio") var inizio: String?,
    @JsonProperty("orario_eng") var orarioEng: String?,
    @JsonProperty("latitudine") var latitudine: String?,
    @JsonProperty("civico") var civico: Any?,
    @JsonProperty("fine") var fine: String?,
    @JsonProperty("bambini") var bambini: String?,
    @JsonProperty("orario_ita") var orarioIta: String?
)

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("eventi")
data class OpendataEvents (
    @JsonProperty("eventi") var eventi: List<Event>
)