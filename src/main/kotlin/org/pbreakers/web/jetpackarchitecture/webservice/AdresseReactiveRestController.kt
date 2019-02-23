package org.pbreakers.web.jetpackarchitecture.webservice

import org.pbreakers.web.jetpackarchitecture.database.entity.Adresse
import org.pbreakers.web.jetpackarchitecture.database.repository.AdresseReactiveRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class AdresseReactiveRestController : HttpMethodController<Adresse> {

    @Autowired
    private lateinit var adresseReactiveRepository: AdresseReactiveRepository

    @PostMapping(value = "adresses")
    override fun add(@RequestBody item: Adresse) {
        adresseReactiveRepository.insert(item)
    }

    @DeleteMapping(value = "adresses/{id}")
    override fun delete(@PathVariable("id") id: String) {
        adresseReactiveRepository.deleteById(id)
    }

    @GetMapping(value = "adresses")
    override fun getAll(): Flux<Adresse> {
        return adresseReactiveRepository.findAll()
    }

    @GetMapping(value = "adresses/{id}")
    override fun getOne(@PathVariable("id") id: String): Mono<Adresse> {
        return adresseReactiveRepository.findById(id)
    }
}