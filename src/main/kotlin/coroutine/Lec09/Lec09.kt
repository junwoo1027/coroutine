package com.example.coroutine.Lec09

suspend fun main() {
    val userService = UserService()
    val findUser = userService.findUser(1)
    println(findUser.toString())
}