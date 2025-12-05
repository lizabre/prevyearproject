package de.thm.mnd.prevyearproject.user

import de.thm.mnd.prevyearproject.notebook.Notebook
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.util.UUID


@Entity
@Table(name = "users")
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id : UUID? = null

    @Column(name = "first_name")
    var firstName: String = ""
    @Column(name = "last_name")
    var lastName: String = ""
    var email: String = ""

    @OneToMany(cascade = [(CascadeType.ALL)], mappedBy = "user")
    var notebooks: List<Notebook> = mutableListOf()

    constructor()

    constructor(firstName: String, lastName: String, email: String) {
        this.firstName = firstName
        this.lastName = lastName
        this.email = email
    }
}