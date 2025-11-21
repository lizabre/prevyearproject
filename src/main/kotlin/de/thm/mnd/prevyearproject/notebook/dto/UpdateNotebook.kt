package de.thm.mnd.prevyearproject.notebook.dto

import de.thm.mnd.prevyearproject.notebook.Notebook
import java.util.UUID

data class UpdateNotebook(
    val name: String
)
fun UpdateNotebook.toNotebook(notebook: Notebook): Notebook = Notebook(
    id = notebook.id,
    name = this.name,
    userId = notebook.userId,
    createdAt = notebook.createdAt,
    notes = notebook.notes
)