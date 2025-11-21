package de.thm.mnd.prevyearproject.prevyearproject.notebook

import java.util.Date
import java.util.UUID

data class Notebook(
    val id: UUID,
    val name: String,
    val createdAt: Date,
    val userId: UUID,
    val notes: MutableList<String> // change to Note data class
)
