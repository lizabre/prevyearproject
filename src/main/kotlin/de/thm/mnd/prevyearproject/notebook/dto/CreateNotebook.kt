package de.thm.mnd.prevyearproject.notebook.dto

import de.thm.mnd.prevyearproject.notebook.Notebook
import java.time.LocalDate
import java.util.Date
import java.util.UUID

data class CreateNotebook(
    val name: String,
    val userId: UUID
)
fun CreateNotebook.toNotebook(): Notebook = Notebook(
    id = UUID.randomUUID(),
    name = this.name,
    createdAt = Date.from(LocalDate.now().atStartOfDay().atZone(java.time.ZoneId.systemDefault()).toInstant()),
    userId = this.userId,
    notes = mutableListOf()
)