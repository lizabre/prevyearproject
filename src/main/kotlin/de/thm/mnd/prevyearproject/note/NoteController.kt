package de.thm.mnd.prevyearproject.note

import de.thm.mnd.prevyearproject.note.dto.NoteRequestDTO
import de.thm.mnd.prevyearproject.note.dto.NoteResponseDTO
import de.thm.mnd.prevyearproject.notebook.NotebookService
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
class NoteController(val noteService: NoteService, val notebookService: NotebookService) {


    private fun Note.toDTO(): NoteResponseDTO = NoteResponseDTO(
        id = this.id,
        name = this.name,
        text = this.text,
        notebookId = this.notebook?.id.toString(),
        createdAt = this.createdAt,
        modifiedAt = this.modifiedAt
    )

    @GetMapping
    fun getAllNotesOfNotebook(@PathVariable notebookId: UUID): List<NoteResponseDTO> {
        return noteService.getNotesByNotebookId(notebookId).map { it.toDTO() }
    }

    @PostMapping
    fun createNote(@PathVariable notebookId: UUID, @RequestBody newNote: NoteRequestDTO): NoteResponseDTO {
        val notebook = notebookService.getNotebookById(notebookId)
        if (notebook == null) {
            throw IllegalArgumentException("Notebook with id $notebookId does not exist.")
        }
        val note = Note(
            name = newNote.name,
            text = newNote.text,
            notebook = notebook
        )
        return noteService.createNote(note).toDTO()
    }

    @PutMapping("/{noteId}")
    fun updateNote(@PathVariable notebookId: UUID, @PathVariable noteId: UUID, @RequestBody updateRequest: NoteRequestDTO): NoteResponseDTO? {
        val notebook = notebookService.getNotebookById(notebookId) ?: return null
        val note = noteService.getNoteById(noteId) ?: return null

        note.name = updateRequest.name
        note.text = updateRequest.text

        return noteService.updateNote(noteId, note)?.toDTO()

    }

    @DeleteMapping("/{noteId}")
    fun deleteNote(@PathVariable notebookId: UUID, @PathVariable noteId: UUID): Unit {
        return noteService.deleteNote(noteId)
    }
}