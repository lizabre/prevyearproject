package de.thm.mnd.prevyearproject.notebook.dto

import java.util.UUID

data class NotebookRequestDTO(
    val name: String,
    val userId: UUID,
)