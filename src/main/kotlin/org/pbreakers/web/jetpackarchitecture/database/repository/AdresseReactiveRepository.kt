package org.pbreakers.web.jetpackarchitecture.database.repository

import org.pbreakers.web.jetpackarchitecture.database.entity.Adresse
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface AdresseReactiveRepository : ReactiveMongoRepository<Adresse, String>