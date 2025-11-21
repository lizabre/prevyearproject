package de.thm.mnd.prevyearproject.note

import de.thm.mnd.prevyearproject.notebook.NotebookService
import notebooksDb
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.UUID


@Service
class NoteService(val notebookService: NotebookService) {

    fun createNote(notebookId: UUID, note: NoteRequest): Note{
        val note = Note(
            id = UUID.randomUUID(),
            createdAt = java.util.Date(),
            modifiedAt = LocalDateTime.now(),
            name = note.name,
            text = note.text,
        )
        val notebook = notebooksDb.find { it.id == notebookId }
        if (notebook != null) {
            notebook.notes.add(note)
        }
        return note
    }

    fun getAllNotesOfNotebook(id: UUID): List<Note>{
        return notebookService.getNotebookById(id)?.notes ?: emptyList()
    }


    fun deleteNote(notebookId: UUID, noteId: UUID){
        val notebook = notebookService.getNotebookById(notebookId)
        if (notebook != null) {
            notebook.notes.removeIf { it.id == noteId }
        }
    }

    fun updateNote(notebookId: UUID, noteId: UUID, updatedNote: NoteRequest ): Note?{
       val notebook = notebookService.getNotebookById(notebookId)
        print(notebook)
        if (notebook != null) {
            val noteToUpdate = notebook.notes.find { it.id == noteId }
            if (noteToUpdate != null) {
                val index = notebook.notes.indexOfFirst { it.id == noteId }
                val newNote = noteToUpdate.copy(
                    name = updatedNote.name,
                    text = updatedNote.text,
                    modifiedAt = LocalDateTime.now()
                )
                notebook.notes[index] = newNote
                return newNote
            }

        }
        return null
    }
}