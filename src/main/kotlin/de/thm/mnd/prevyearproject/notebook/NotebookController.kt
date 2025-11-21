package de.thm.mnd.prevyearproject.notebook

import de.thm.mnd.prevyearproject.notebook.dto.CreateNotebook
import de.thm.mnd.prevyearproject.notebook.dto.UpdateNotebook
import de.thm.mnd.prevyearproject.notebook.dto.toNotebook
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
class NotebookController(val notebookService: NotebookService) {

    @GetMapping
    fun getAllNotebooks(): List<Notebook> {
        return notebookService.getAllNotebooks()
    }

    @GetMapping("/{id}")
    fun getNotebookById(@PathVariable id: UUID): Notebook? {
        return notebookService.getNotebookById(id)
    }

    @PostMapping
    fun createNotebook(@RequestBody newNotebook: CreateNotebook): Notebook {
        return notebookService.createNotebook(newNotebook.toNotebook())
    }

    @PutMapping("/{id}")
    fun updateNotebook(@PathVariable id: UUID, @RequestBody updateRequest: UpdateNotebook): Notebook? {
        val existingNotebook = notebookService.getNotebookById(id) ?: return null;

        return notebookService.updateNotebook(id, updateRequest.toNotebook(existingNotebook));
    }

    @DeleteMapping("/{id}")
    fun deleteNotebook(@PathVariable id: UUID): Boolean {
        return notebookService.deleteNotebook(id);
    }
}