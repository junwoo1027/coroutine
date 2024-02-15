package com.example.coroutine.Lec05

import com.example.printWithThread
import kotlinx.coroutines.*

fun main():Unit = runBlocking {
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        printWithThread("예외")
        throw throwable
    }

    val job = CoroutineScope(Dispatchers.Default).launch(exceptionHandler) {
        throw IllegalArgumentException()
    }

    delay(1000)
}

fun example2(): Unit = runBlocking {
   val job = async(SupervisorJob()) {
       throw IllegalArgumentException()
   }

    delay(1000)
//    job.await()
}

fun example1():Unit = runBlocking {
    val job = CoroutineScope(Dispatchers.Default).async {
        throw IllegalArgumentException()
    }

    delay(1000)
    job.await()
}