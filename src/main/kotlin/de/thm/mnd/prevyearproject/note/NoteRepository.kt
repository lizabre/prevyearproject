package de.thm.mnd.prevyearproject.note

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID


@Repository
interface NoteRepository: CrudRepository<Note, UUID> {

}