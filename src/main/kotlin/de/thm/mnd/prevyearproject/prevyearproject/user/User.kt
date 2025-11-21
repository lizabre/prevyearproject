package de.thm.mnd.prevyearproject.prevyearproject.user

import java.util.UUID

data class User (
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val email: String
)