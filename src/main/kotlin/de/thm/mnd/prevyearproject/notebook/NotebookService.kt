package de.thm.mnd.prevyearproject.notebook

import org.springframework.stereotype.Service
import java.util.UUID


@Service
class NotebookService(private val notebookRepository: NotebookRepository) {
    fun getNotebookById(id: UUID): Notebook? {
        return notebookRepository.findById(id).orElse(null)
    }

    fun createNotebook(notebook: Notebook): Notebook {
        return notebookRepository.save(notebook)
    }

    fun deleteNotebook(id: UUID) {
        notebookRepository.deleteById(id)
    }
    fun getAllNotebooks(): List<Notebook> {
        return notebookRepository.findAll().toList()
    }
    fun updateNotebook(id: UUID, updatedNotebook: Notebook): Notebook? {
        return if (notebookRepository.existsById(id)) {
            notebookRepository.save(updatedNotebook)
        } else {
            null
        }
    }

    fun getNotebooksByUserId(userId: UUID): List<Notebook> {
        return notebookRepository.findAll().filter { it.user?.id == userId }
    }

}