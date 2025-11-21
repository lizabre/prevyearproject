package de.thm.mnd.prevyearproject.user.dto

import de.thm.mnd.prevyearproject.user.User
import java.util.UUID

data class UserRequest (
    val firstName: String,
    val lastName: String,
    val email: String
)
fun UserRequest.toUser(): User = User(
    id = UUID.randomUUID(),
    firstName = this.firstName,
    lastName = this.lastName,
    email = this.email
)
fun UserRequest.toUser(id:UUID): User = User(
    id = id,
    firstName = this.firstName,
    lastName = this.lastName,
    email = this.email
)