package com.example.coroutine.Lec08

import com.example.printWithThread
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull

fun main(): Unit = runBlocking {
//    val result = withTimeout(1000) {
//        delay(1500)
//        10 + 20
//    }

    val result = withTimeoutOrNull(1000) {
        delay(1500)
        10 + 20
    }

    printWithThread(result.toString())
}