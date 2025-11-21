package de.thm.mnd.prevyearproject.prevyearproject.notebook

import org.springframework.stereotype.Service
import java.util.UUID


@Service
class NotebookService {

    private val notebooks = mutableListOf<Notebook>()

    fun createNotebook(newNotebook: NotebookRequest): Notebook {
        val id = UUID.randomUUID().mostSignificantBits and Long.MAX_VALUE
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

    fun deleteNotebook(id: Long) {
        notebooks.removeIf { it.id == id }
    }

    fun updateNotebook(id: Long, name: String): Notebook? {
        val index = notebooks.indexOfFirst { it.id == id }
        if (index != -1) {
            val notebookToUpdate = notebooks[index]
            val updatedNotebook = notebookToUpdate.copy(name = name)
            notebooks[index] = updatedNotebook
            return updatedNotebook
        }
        return null
    }
}