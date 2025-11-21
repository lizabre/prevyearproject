package de.thm.mnd.prevyearproject.prevyearproject.notebook

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/notebooks")
class NotebookController(val notebookService: NotebookService) {

    @GetMapping
    fun getAllNotebooks(): List<Notebook> {
        return notebookService.getAllNotebooks()
    }

    @PostMapping
    fun createNotebook(@RequestBody newNotebook: NotebookRequest): Notebook {
        return notebookService.createNotebook(newNotebook)
    }
}