package org.pbreakers.web.jetpackarchitecture.webservice

import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
interface HttpMethodController<T> {
    fun add(item: T)
    fun delete(id: String)
    fun getOne(id: String): Mono<T>
    fun getAll(): Flux<T>
}