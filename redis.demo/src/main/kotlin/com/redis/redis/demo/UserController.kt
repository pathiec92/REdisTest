package com.redis.redis.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(private val userService: UserService) {

    @GetMapping("/user/{id}")
    fun getUserById(@PathVariable id: Long) = userService.getUserById(id)
}