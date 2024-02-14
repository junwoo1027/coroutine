package com.example.coroutine.Lec03

import com.example.printWithThread
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main(): Unit = runBlocking {
    val time = measureTimeMillis {
        val job1 = async(start = CoroutineStart.LAZY) { apiCall1() }
        val job2 = async(start = CoroutineStart.LAZY) { apiCall2() }
        job1.start()
        job2.start()

        printWithThread((job1.await() + job2.await()).toString())
    }

    printWithThread("$time")
}

suspend fun apiCall1(): Int {
    delay(1000)
    return 1
}
suspend fun apiCall2(): Int {
    delay(1000)
    return 2
}

fun example4(): Unit = runBlocking {
    val job1 = launch {
        delay(1000)
        printWithThread("job1")
    }
    job1.join()

    val job2 = launch {
        delay(1000)
        printWithThread("job2")
    }
}

fun example3(): Unit = runBlocking {
    val job = launch {
        (1..5).forEach {
            println(it)
            delay(500)
        }
    }

    delay(1000)
    job.cancel()
}

fun example2(): Unit = runBlocking {
    val job = launch(start = CoroutineStart.LAZY) {
        printWithThread("Hello launch")
    }

    delay(1000)
    job.start()
}

fun example1() {
    runBlocking {
        printWithThread("start")
        launch {
            delay(2000)
            printWithThread("launch end")
        }
    }

    printWithThread("end")
}