package de.thm.mnd.prevyearproject.notebook

import de.thm.mnd.prevyearproject.prevyearproject.note.Note
import java.util.Date
import java.util.UUID

data class Notebook(
    val id: UUID,
    val name: String,
    val createdAt: Date,
    val userId: UUID,
    val notes: MutableList<Note>
)
