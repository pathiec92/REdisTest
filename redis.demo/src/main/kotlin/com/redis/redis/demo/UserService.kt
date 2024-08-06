package com.redis.redis.demo

import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import java.io.Serializable
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
data class User @JsonCreator constructor(
    @JsonProperty("id") val id: Long = 0,
    @JsonProperty("name")val name: String = "",
    @JsonProperty("email") val email: String = ""): Serializable

@Service
class UserService {

    @Cacheable(value = ["userCache"], key = "#id")
    fun getUserById(id: Long): User {
        Thread.sleep(2000)
        return User(id, "John Doe", "john.doe@example.com")
    }
}