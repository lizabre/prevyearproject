package de.thm.mnd.prevyearproject.note.dto

import java.time.LocalDateTime
import java.util.Date
import java.util.UUID

data class NoteResponseDTO(
    val id: UUID?,
    val name: String,
    val text: String,
    val notebookId: String,
    val createdAt: LocalDateTime?,
    val modifiedAt: LocalDateTime?,
)