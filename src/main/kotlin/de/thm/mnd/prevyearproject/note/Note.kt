package de.thm.mnd.prevyearproject.note

import de.thm.mnd.prevyearproject.notebook.Notebook
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.PrePersist
import jakarta.persistence.PreUpdate
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "notes")
class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id : UUID? = null
    var name: String = ""
    var text: String = ""

    @Column(name = "created_at")
    var createdAt: LocalDateTime? = null
    @Column(name = "modified_at")
    var modifiedAt: LocalDateTime? = null

    @ManyToOne
    @JoinColumn(name = "notebook_id", nullable = false)
    var notebook: Notebook? = null

    constructor()

    constructor(name: String, text: String, notebook: Notebook) {
        this.name = name
        this.text = text
        this.notebook = notebook
    }

    @PrePersist
    fun onCreate() {
        val now = LocalDateTime.now()
        createdAt = now
        modifiedAt = now
    }

    @PreUpdate
    fun onUpdate() {
        modifiedAt = LocalDateTime.now()
    }

}