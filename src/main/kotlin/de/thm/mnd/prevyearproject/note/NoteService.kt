package de.thm.mnd.prevyearproject.note

import de.thm.mnd.prevyearproject.notebook.NotebookService
import notebooksDb
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.UUID


@Service
class NoteService(val notebookService: NotebookService) {


    fun createNote(note: NoteRequest){
        val note = Note(
            id = UUID.randomUUID(),
            createdAt = java.util.Date(),
            modifiedAt = LocalDateTime.now(),
            name = note.name,
            text = note.text,
            notebookId = note.notebookId
        )
        val notebook = notebooksDb.find { it.id == note.notebookId }
        if (notebook != null) {
            notebook.notes.add(note)
        }

    }

//    fun getAllNotes(): List<Note>{
//        return notebooksDb.map { it -> it.notes }.flatten()
//    }
//    fun getNote(id: UUID) : Note?{
//        for (note in noteList){
//            if(note.id == id){
//                return note
//            }
//        }
//        return null
//    }

//    fun deleteNote(note: Note){
//        noteList.remove(note)
//    }
//    fun updateNote(noteId: UUID , updatedNote: NoteRequest ){
//        val note = getNote(noteId)
//        if (note != null) {
//            note.name = updatedNote.name
//            note.text = updatedNote.text
//            note.modifiedAt = LocalDateTime.now()
//        }
//    }

}