package com.example.coroutine.Lec06

import com.example.printWithThread
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val job1 = launch {
        delay(600)
        printWithThread("a")
    }

    val job = launch {
        delay(500)
        throw IllegalArgumentException()
    }

    /**
     * Structured Concurrency
     * - 자식 코루틴에서 예외가 발생할 경우, Structured Concurrency 에 의해 부모 코루틴이 취소되고,
     *   부모 코루틴의 다른 자식 코루틴들도 취소된다.
     * - 자식 코루틴에서 예외가 발생하지 않더라도 부모 코루틴이 취소되면, 자식 코루틴들이 취소된다.
     * - CancellationException 은 정상적인 취소로 간주히기 때문에 부모 코루틴에게 전파되지 않고,
     *   부모 코루틴의 다른 자식 코루틴을 취소시키지 않는다.
     */
}