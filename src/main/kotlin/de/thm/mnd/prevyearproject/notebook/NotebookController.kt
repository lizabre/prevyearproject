package de.thm.mnd.prevyearproject.notebook

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

    @PostMapping
    fun createNotebook(@RequestBody newNotebook: CreateNotebook): Notebook {
        return notebookService.createNotebook(newNotebook)
    }

    @PutMapping("/{id}")
    fun updateNotebook(@PathVariable id: UUID, @RequestBody updateRequest: UpdateNotebook): Notebook? {
        return notebookService.updateNotebook(id, updateRequest)
    }
}