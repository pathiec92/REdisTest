package com.redis.redis.demo

import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import java.io.Serializable

data class User(val id: Long, val name: String, val email: String): Serializable

@Service
class UserService {

    @Cacheable(value = ["userCache"], key = "#id")
    fun getUserById(id: Long): User {
        Thread.sleep(2000)
        return User(id, "John Doe", "john.doe@example.com")
    }
}