package de.thm.mnd.prevyearproject

import de.thm.mnd.prevyearproject.note.NoteService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class PrevyearprojectApplication

fun main(args: Array<String>) {
    runApplication<de.thm.mnd.prevyearproject.PrevyearprojectApplication>(*args)
}
