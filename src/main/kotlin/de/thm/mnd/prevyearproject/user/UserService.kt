package de.thm.mnd.prevyearproject.user

import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserService(private val userRepository: UserRepository) {

    fun getUserById(id: UUID): User? {
        return userRepository.findById(id).orElse(null)
    }

    fun createUser(user: User): User {
        return userRepository.save(user)
    }

    fun deleteUser(id: UUID) {
        userRepository.deleteById(id)
    }

    fun getAllUsers(): List<User> {
        return userRepository.findAll().toList()
    }

    fun updateUser(id: UUID, updatedUser: User): User? {
        return if (userRepository.existsById(id)) {
            userRepository.save(updatedUser)
        } else {
            null
        }
    }
}