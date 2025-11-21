package de.thm.mnd.prevyearproject.prevyearproject

import java.time.LocalDate
import java.util.UUID

data class NoteRequest(
    var name: String,
    var text: String,
    val notebook: Notebook
)
