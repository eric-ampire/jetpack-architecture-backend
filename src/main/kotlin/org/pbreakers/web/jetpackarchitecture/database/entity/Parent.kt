package org.pbreakers.web.jetpackarchitecture.database.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Parent(
    @Id val id: String,
    @DBRef val adresse: Adresse,
    @DBRef val enfants: List<Enfant> = arrayListOf(),
    val nom: String,
    val prenom: String,
    val genre: Char
)