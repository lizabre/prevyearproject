package de.thm.mnd.prevyearproject.note

import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.UUID


@Service
class NoteService(private val noteRepository: NoteRepository){
    fun getNoteById(id: UUID): Note? {
        return noteRepository.findById(id).orElse(null)
    }

    fun createNote(note: Note): Note {
        return noteRepository.save(note)
    }

    fun deleteNote(id: UUID) {
        noteRepository.deleteById(id)
    }
    fun getAllNotes(): List<Note> {
        return noteRepository.findAll().toList()
    }
    fun updateNote(id: UUID, updatedNote: Note): Note? {
        return if (noteRepository.existsById(id)) {
            updatedNote.modifiedAt = LocalDateTime.now()
            noteRepository.save(updatedNote)
        } else {
            null
        }
    }

    fun getNotesByNotebookId(notebookId: UUID): List<Note> {
        return noteRepository.findAll().filter { it.notebook?.id == notebookId }
    }
}