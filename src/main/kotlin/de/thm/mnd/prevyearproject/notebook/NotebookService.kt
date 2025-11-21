package de.thm.mnd.prevyearproject.notebook

import notebooksDb
import org.springframework.stereotype.Service
import java.util.UUID


@Service
class NotebookService {

    fun createNotebook(newNotebook: CreateNotebook): Notebook {
        val id = UUID.randomUUID()
        val notebook = Notebook(
            id = id,
            name = newNotebook.name,
            createdAt = java.util.Date(),
            userId = newNotebook.userId,
            notes = mutableListOf()
        )
        notebooksDb.add(notebook)
        return notebook
    }

    fun getAllNotebooks(): List<Notebook> {
        return notebooksDb
    }
    fun getNotebookById(id: UUID): Notebook? {
        return notebooksDb.find { it.id == id }
    }

    fun deleteNotebook(id: UUID) {
        notebooksDb.removeIf { it.id == id }
    }

    fun updateNotebook(id: UUID, updatedNotebook: UpdateNotebook): Notebook? {
        val index = notebooksDb.indexOfFirst { it.id == id}
        if (index != -1) {
            val notebookToUpdate = notebooksDb[index]
            val updatedNotebook = notebookToUpdate.copy(name = updatedNotebook.name)
            notebooksDb[index] = updatedNotebook
            return updatedNotebook
        }
        return null
    }
}