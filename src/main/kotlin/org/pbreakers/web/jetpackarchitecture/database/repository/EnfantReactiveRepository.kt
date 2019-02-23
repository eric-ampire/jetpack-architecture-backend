package org.pbreakers.web.jetpackarchitecture.database.repository

import org.pbreakers.web.jetpackarchitecture.database.entity.Enfant
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface EnfantReactiveRepository : ReactiveMongoRepository<Enfant, String>