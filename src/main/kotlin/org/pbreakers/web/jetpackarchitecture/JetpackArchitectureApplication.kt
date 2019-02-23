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
		val adresse = Adresse(
			id = UUID.randomUUID().toString(),
			commune = "Annexe",
			numero = "565",
			avenue = "Likasi"
		)

		val enfant = Enfant(
			id = UUID.randomUUID().toString(),
			nom = "Ampire",
			prenom = "Eric"
		)

		enfantRepository.insert(enfant).subscribe { savedEnfant ->
			adresseRepository.insert(adresse).subscribe { savedAdresse ->
				val parent = Parent(
					id = UUID.randomUUID().toString(),
					nom = "Bigomokero",
					prenom = "Bernard",
					adresse = savedAdresse,
					genre = 'M'
				)

				parentRepository.insert(parent).subscribe { savedParent ->


					parentRepository.findById(savedAdresse.id).subscribe {
						it.enfants.add(savedEnfant)

						parentRepository.insert(it).subscribe {
							println(savedAdresse)
							println(savedParent)
						}
					}
				}
			}
		}
	}
}

fun main(args: Array<String>) {
	runApplication<JetpackArchitectureApplication>(*args)
}
