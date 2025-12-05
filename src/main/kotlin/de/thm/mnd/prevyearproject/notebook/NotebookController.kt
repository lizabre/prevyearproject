package de.thm.mnd.prevyearproject.notebook

import de.thm.mnd.prevyearproject.note.Note
import de.thm.mnd.prevyearproject.note.dto.NoteResponseDTO
import de.thm.mnd.prevyearproject.notebook.dto.NotebookRequestDTO
import de.thm.mnd.prevyearproject.notebook.dto.NotebookResponseDTO
import de.thm.mnd.prevyearproject.user.UserService
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
@RequestMapping("/notebooks")
class NotebookController(val notebookService: NotebookService, val userService: UserService) {

    private fun Note.toDTO(): NoteResponseDTO = NoteResponseDTO(
        id = this.id,
        name = this.name,
        text = this.text,
        notebookId = this.notebook?.id.toString(),
        createdAt = this.createdAt,
        modifiedAt = this.modifiedAt
    )

    private fun Notebook.toDTO(): NotebookResponseDTO = NotebookResponseDTO(
        id = this.id,
        name = this.name,
        userId = this.user?.id,
        createdAt = this.createdAt,
        notes = this.notes.map { it.toDTO() }
    )

    @GetMapping
    fun getAllNotebooks(): List<NotebookResponseDTO> {

        return notebookService.getAllNotebooks().map { it.toDTO() }
    }

    @GetMapping("/{id}")
    fun getNotebookById(@PathVariable id: UUID): NotebookResponseDTO? {
        return notebookService.getNotebookById(id)?.toDTO()
    }

    @PostMapping
    fun createNotebook(@RequestBody newNotebook: NotebookRequestDTO): NotebookResponseDTO {
        val user = userService.getUserById(newNotebook.userId)
        if(user == null) {
            throw IllegalArgumentException("User with id ${newNotebook.userId} does not exist.")
        }
        val notebook = Notebook(
            name = newNotebook.name,
            user = user
        )
        return notebookService.createNotebook(notebook).toDTO()
    }

    @PutMapping("/{id}")
    fun updateNotebook(@PathVariable id: UUID, @RequestBody updatedBook: NotebookRequestDTO): NotebookResponseDTO? {
        val notebook = notebookService.getNotebookById(id) ?: return null
        val user = userService.getUserById(updatedBook.userId) ?: return null

        notebook.name = updatedBook.name
        notebook.user = user
        return notebookService.updateNotebook(id, notebook)?.toDTO()
    }

    @DeleteMapping("/{id}")
    fun deleteNotebook(@PathVariable id: UUID): Unit {
        return notebookService.deleteNotebook(id);
    }
}