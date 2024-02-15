package com.example.coroutine.Lec09

class UserService {
    private val userProfileRepository = UserProfileRepository()
    private val userImageRepository = UserImageRepository()

    suspend fun findUser(userId: Long): UserDto {
        println("프로필을 가져오겠습니다")
        val profile = userProfileRepository.findProfile(userId)
        println("이미지를 가져오겠습니다")
        val image = userImageRepository.findImage(profile)
        return UserDto(profile, image)
    }
}