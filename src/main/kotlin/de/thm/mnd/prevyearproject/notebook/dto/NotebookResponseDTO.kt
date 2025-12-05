package de.thm.mnd.prevyearproject.notebook.dto

import de.thm.mnd.prevyearproject.note.dto.NoteResponseDTO
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID

data class NotebookResponseDTO(
    val id: UUID?,
    val name: String,
    val userId: UUID?,
    val createdAt: LocalDateTime?,
    val notes: List<NoteResponseDTO>,
)