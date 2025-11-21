package de.thm.mnd.prevyearproject.prevyearproject.notebook

import org.springframework.stereotype.Service
import java.util.UUID


@Service
class NotebookService {

    private val notebooks = mutableListOf<Notebook>()

    fun createNotebook(newNotebook: CreateNotebook): Notebook {
        val id = UUID.randomUUID()
        val notebook = Notebook(
            id = id,
            name = newNotebook.name,
            createdAt = java.util.Date(),
            userId = newNotebook.userId,
            notes = mutableListOf()
        )
        notebooks.add(notebook)
        return notebook
    }

    fun getAllNotebooks(): List<Notebook> {
        return notebooks
    }

    fun deleteNotebook(id: UUID) {
        notebooks.removeIf { it.id == id }
    }

    fun updateNotebook(updatedNotebook: UpdateNotebook): Notebook? {
        val index = notebooks.indexOfFirst { it.id == updatedNotebook.id }
        if (index != -1) {
            val notebookToUpdate = notebooks[index]
            val updatedNotebook = notebookToUpdate.copy(name = updatedNotebook.name)
            notebooks[index] = updatedNotebook
            return updatedNotebook
        }
        return null
    }
}