package org.pbreakers.web.jetpackarchitecture.database.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document
class Enfant(
    @Id val id: String,
    val nom: String,
    val prenom: String
)