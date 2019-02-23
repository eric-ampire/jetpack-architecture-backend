package org.pbreakers.web.jetpackarchitecture.webservice

import org.pbreakers.web.jetpackarchitecture.database.entity.Parent
import org.pbreakers.web.jetpackarchitecture.database.repository.ParentReactiveRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class ParentReactiveRestController : HttpMethodController<Parent> {
    @Autowired
    private lateinit var parentRepository: ParentReactiveRepository

    @PostMapping(value = "/parents")
    override fun add(@RequestBody item: Parent) {
        parentRepository.insert(item)
    }

    @DeleteMapping(value = "/parents/{id}")
    override fun delete(@PathVariable(value = "id") id: String) {
        parentRepository.deleteById(id)
    }

    @GetMapping(value = "/parents/{id}")
    override fun getOne(@PathVariable(value = "id") id: String): Mono<Parent> {
        return parentRepository.findById(id)
    }

    @GetMapping(value = "/parents")
    override fun getAll(): Flux<Parent> {
        return parentRepository.findAll()
    }
}