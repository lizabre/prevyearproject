package de.thm.mnd.prevyearproject.prevyearproject.notebook

import java.util.UUID

data class CreateNotebook(
    val name: String,
    val userId: UUID
)
