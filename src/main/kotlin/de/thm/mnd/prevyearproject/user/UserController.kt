package de.thm.mnd.prevyearproject.user

import de.thm.mnd.prevyearproject.user.dto.UserDTO
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID


@RestController
@RequestMapping("/users")
class UserController(val userService: UserService) {

    private fun User.toDTO(): UserDTO = UserDTO(
        id = this.id,
        firstName = this.firstName,
        lastName = this.lastName,
        email = this.email
    )
    @GetMapping
    fun getAllUsers(): List<UserDTO> {
        return userService.getAllUsers().map { it.toDTO() }
    };
    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: UUID): UserDTO? {
        return userService.getUserById(id)?.toDTO()
    };
    @PostMapping
    fun createUser(@RequestBody user: UserDTO): UserDTO {
        val user = User(
            firstName = user.firstName,
            lastName = user.lastName,
            email = user.email
        )
        return userService.createUser(user).toDTO()
    };
    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: UUID, @RequestBody user: UserDTO): UserDTO? {
        val updatedUser = User(
            firstName = user.firstName,
            lastName = user.lastName,
            email = user.email
        )
        return userService.updateUser(id, updatedUser)?.toDTO()
    }
    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: UUID): Unit = userService.deleteUser(id);
}