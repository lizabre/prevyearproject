package de.thm.mnd.prevyearproject.user.dto

import java.util.UUID

data class UserDTO(
    val id: UUID?,
    val firstName: String,
    val lastName: String,
    val email: String,
)