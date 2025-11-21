package de.thm.mnd.prevyearproject.note

import java.time.LocalDateTime
import java.util.Date
import java.util.UUID

data class Note(
    var id : UUID,
    var createdAt: Date,
    var modifiedAt: LocalDateTime,
    var name: String,
    var text: String,
)