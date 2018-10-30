package io.github.mpao.florencebackend.models

import io.github.mpao.florencebackend.entities.Event
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

/**
 * Interfaccia per mongoDB; mette a disposizioni metodi CRUD di default
 */
@Repository
interface EventRepository : ReactiveMongoRepository<Event, String> {
}