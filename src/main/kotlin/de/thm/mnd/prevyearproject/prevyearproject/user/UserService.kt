package de.thm.mnd.prevyearproject.prevyearproject.user

import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserService{
    val users = mutableListOf<User>();
    fun getAllUsers():List<User> = users;
    fun getUserById(id: UUID):User? = users.find { it.id == id };
    fun save(user: User): User {
        users.add(user);
        return user;
    }
    fun update(user: User): User? {
        val existingUser = users.find { it.id == user.id }
        if (existingUser != null) {
            val ind = users.indexOf(existingUser)
            users.remove(existingUser)
            users.add(ind, user)
            return user
        }
        return null
    }
    fun delete(id: UUID): Boolean {
        val existingUser = users.find { it.id == id }
        if (existingUser != null) {
            users.remove(existingUser)
            return true
        }
        return false
    }
}