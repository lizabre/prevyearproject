package de.thm.mnd.prevyearproject.notebook

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.UUID


@Repository
interface NotebookRepository: CrudRepository<Notebook, UUID> {
}