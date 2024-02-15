package com.example.coroutine.Lec09

import kotlinx.coroutines.delay

class UserImageRepository {
    suspend fun findImage(profile: Profile): Image {
        delay(100)
        return Image()
    }
}
