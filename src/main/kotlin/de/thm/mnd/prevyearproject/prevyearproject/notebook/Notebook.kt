package de.thm.mnd.prevyearproject.prevyearproject.notebook

import java.util.Date

data class Notebook(
    val id: Long,
    val name: String,
    val createdAt: Date,
    val userId: Long,
    val notes: MutableList<String> // change to Note data class
)
