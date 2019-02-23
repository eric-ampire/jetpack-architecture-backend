package org.pbreakers.web.jetpackarchitecture.webservice

import org.pbreakers.web.jetpackarchitecture.database.entity.Enfant
import org.pbreakers.web.jetpackarchitecture.database.repository.EnfantReactiveRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class EnfantReactiveRestController {

    @Autowired
    private lateinit var enfantReactiveRepository: EnfantReactiveRepository

    @GetMapping("enfants")
    fun getAll(): Flux<Enfant> {
        return enfantReactiveRepository.findAll()
    }

    @PostMapping("enfants")
    fun add(@RequestBody enfant: Enfant) {
        enfantReactiveRepository.insert(enfant)
    }
}