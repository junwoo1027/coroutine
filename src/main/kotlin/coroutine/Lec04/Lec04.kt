package com.example.coroutine.Lec04

import com.example.printWithThread
import kotlinx.coroutines.*

fun main(): Unit = runBlocking {
    val job = launch(Dispatchers.Default) {
        var i = 1
        var nextPrintTime = System.currentTimeMillis()
        while (i <= 5) {
            if (nextPrintTime <= System.currentTimeMillis()) {
                printWithThread("${i++}번째 출력")
                println(nextPrintTime)
                nextPrintTime += 1_000L
            }

            if (!isActive) {
                throw CancellationException()
            }
        }
    }

    delay(1000)
    job.cancel()
}

fun example1(): Unit = runBlocking {
    val job1 = launch {
        delay(1000)
        printWithThread("job1")
    }

    val job2 = launch {
        delay(1000)
        printWithThread("job2")
    }

    delay(100)
    job1.cancel()
}