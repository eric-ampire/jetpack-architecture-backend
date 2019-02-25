package org.pbreakers.web.jetpackarchitecture

import org.pbreakers.web.jetpackarchitecture.database.entity.*
import org.pbreakers.web.jetpackarchitecture.database.repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import java.util.*

@SpringBootApplication
class JetpackArchitectureApplication: CommandLineRunner {

	@Autowired private lateinit var parentRepository: ParentReactiveRepository
	@Autowired private lateinit var enfantRepository: EnfantReactiveRepository
	@Autowired private lateinit var adresseRepository: AdresseReactiveRepository

	override fun run(vararg args: String) {

	}
}

fun main(args: Array<String>) {
	System.setProperty("spring.devtools.restart.enabled", "true")
	runApplication<JetpackArchitectureApplication>(*args)
}
