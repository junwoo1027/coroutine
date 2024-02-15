package com.example.coroutine.Lec09

import kotlinx.coroutines.delay

class UserProfileRepository {
    suspend fun findProfile(userId: Long): Profile {
        delay(100)
        return Profile()
    }
}
