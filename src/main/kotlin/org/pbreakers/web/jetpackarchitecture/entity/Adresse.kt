package org.pbreakers.web.jetpackarchitecture.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Adresse(
    @Id val id: String,
    val commune: String,
    val numero: String,
    val avenue: String
)