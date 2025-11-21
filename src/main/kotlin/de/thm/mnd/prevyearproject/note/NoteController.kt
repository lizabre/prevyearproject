package de.thm.mnd.prevyearproject.note

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID


@RestController
@RequestMapping("/notes")
class NoteController(val noteService: NoteService) {

    @GetMapping
    fun getAllNotebooks(): List<Note> {
        return noteService.getAllNotes()
    }

    @PostMapping
    fun createNotebook(@RequestBody newNote: NoteRequest) {
        return noteService.createNote(newNote)
    }

//    @PutMapping("/{id}")
//    fun updateNotebook(@PathVariable id: UUID, @RequestBody updateRequest: NoteRequest) {
//        return noteService.updateNote(id, updateRequest)
//    }
}