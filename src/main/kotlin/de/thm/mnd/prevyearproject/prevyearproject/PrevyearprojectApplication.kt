package de.thm.mnd.prevyearproject.prevyearproject

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class PrevyearprojectApplication

fun main(args: Array<String>) {
    runApplication<PrevyearprojectApplication>(*args)
}

@RestController
@RequestMapping("/notes")
class NoteController(val noteService: NoteService){

    @PostMapping

}