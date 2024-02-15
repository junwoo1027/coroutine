package com.example.coroutine.Lec08

import com.example.printWithThread
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    printWithThread("start")
    printWithThread(calc().toString())
    printWithThread("end")
}

suspend fun calc(): Int = coroutineScope {
    val num1 = async {
        delay(1000)
        10
    }

    val num2 = async {
        delay(1000)
        20
    }

    num1.await() + num2.await()
}