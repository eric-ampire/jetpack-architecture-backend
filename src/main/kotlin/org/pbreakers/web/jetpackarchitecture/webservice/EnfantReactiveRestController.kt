package org.pbreakers.web.jetpackarchitecture.webservice

import org.pbreakers.web.jetpackarchitecture.database.entity.Enfant
import org.pbreakers.web.jetpackarchitecture.database.repository.EnfantReactiveRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class EnfantReactiveRestController : HttpMethodController<Enfant> {

    @Autowired private lateinit var enfantReactiveRepository: EnfantReactiveRepository

    @PostMapping(value = "enfants")
    override fun add(@RequestBody item: Enfant) {
        enfantReactiveRepository.insert(item)
    }

    @DeleteMapping(value = "enfants/{id}")
    override fun delete(@PathVariable("id") id: String) {
        enfantReactiveRepository.deleteById(id)
    }

    @GetMapping("enfants/{id}")
    override fun getOne(@PathVariable("id") id: String): Mono<Enfant> {
        return enfantReactiveRepository.findById(id)
    }

    @GetMapping("enfants")
    override fun getAll(): Flux<Enfant> {
        return enfantReactiveRepository.findAll()
    }
}