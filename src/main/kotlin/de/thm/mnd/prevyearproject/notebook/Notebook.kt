package de.thm.mnd.prevyearproject.notebook

import de.thm.mnd.prevyearproject.note.Note
import de.thm.mnd.prevyearproject.user.User
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.PrePersist
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "notebooks")
class Notebook {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id : UUID? = null
    var name: String = ""

    @Column(name = "created_at")
    var createdAt: LocalDateTime? = null


    @OneToMany(cascade = [CascadeType.ALL],mappedBy = "notebook")
    var notes: List<Note> = mutableListOf()

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    var user: User? = null

    constructor()

    constructor(name: String, user: User) {
        this.name = name
        this.user = user
    }

    @PrePersist
    fun onCreate() {
        createdAt = LocalDateTime.now()
    }
}