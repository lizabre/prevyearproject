package de.thm.mnd.prevyearproject.prevyearproject

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

class NoteService {
    val noteList = mutableListOf<Note>()

    fun createNote(note: Note){
        noteList.add(note)
    }

    fun getAllNotes(): List<Note>{
        return noteList
    }
    fun getNote(id: UUID) : Note?{
        for (note in noteList){
            if(note.id == id){
                return note
            }
        }
        return null
    }

    fun deleteNote(note: Note){
        noteList.remove(note)
    }
    fun updateNote(note: Note, name:String, text:String){
        noteList.remove(note)
        note.text = text
        note.name = name
        note.modifiedAt = LocalDate.now()
        noteList.add(note)
    }

}