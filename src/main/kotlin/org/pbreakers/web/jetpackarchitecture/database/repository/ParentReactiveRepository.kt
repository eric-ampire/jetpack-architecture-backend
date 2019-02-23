package org.pbreakers.web.jetpackarchitecture.database.repository

import org.pbreakers.web.jetpackarchitecture.database.entity.Parent
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface ParentReactiveRepository : ReactiveMongoRepository<Parent, String> {
    fun getParentBy(id: String): Mono<Parent>
    fun getAll(): Flux<Parent>
    fun insert(parent: Parent): Mono<Parent>
}