package de.thm.mnd.prevyearproject.note

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID


@RestController
@RequestMapping("/notebooks/{notebookId}/notes")
class NoteController(val noteService: NoteService) {

    @GetMapping
    fun getAllNotesOfNotebook(@PathVariable notebookId: UUID): List<Note> {
        return noteService.getAllNotesOfNotebook(notebookId)
    }

    @PostMapping
    fun createNote(@PathVariable notebookId: UUID, @RequestBody newNote: NoteRequest): Note {
        return noteService.createNote(notebookId, newNote)
    }

    @PutMapping("/{noteId}")
    fun updateNotebook(@PathVariable notebookId: UUID, @PathVariable noteId: UUID, @RequestBody updateRequest: NoteRequest): Note? {
        return noteService.updateNote(notebookId, noteId, updateRequest)
    }

    @DeleteMapping("/{noteId}")
    fun deleteNote(@PathVariable notebookId: UUID, @PathVariable noteId: UUID) {
        return noteService.deleteNote(notebookId, noteId)
    }
}