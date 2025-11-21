package de.thm.mnd.prevyearproject.prevyearproject

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

data class Note(
    var id : UUID,
    var createdAt: LocalDate,
    var modifiedAt: LocalDate,
    var name: String,
    var text: String,
    val notebook: Notebook
){
    init{
        id = UUID.randomUUID()
        createdAt = LocalDate.now()
    }
}
