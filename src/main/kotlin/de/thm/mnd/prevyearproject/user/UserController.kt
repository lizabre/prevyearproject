package de.thm.mnd.prevyearproject.user

import de.thm.mnd.prevyearproject.user.dto.UserRequest
import de.thm.mnd.prevyearproject.user.dto.toUser
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
    @GetMapping
    fun getAllUsers(): List<User> = userService.getAllUsers();
    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: UUID): User? = userService.getUserById(id);
    @PostMapping
    fun createUser(@RequestBody user: UserRequest): User = userService.save(user.toUser());
    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: UUID, @RequestBody user: UserRequest): User? = userService.update(user.toUser(id));
    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: UUID): Boolean = userService.delete(id);
}