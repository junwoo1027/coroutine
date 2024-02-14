package com.example

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

fun main(): Unit = runBlocking { /** runBlocking: 일반루틴과 코루틴 연결 */
    printWithThread("start")
    launch { /** launch: 반환값이 없는 코루틴을 만든다. */
        newRoutine()
    }
    yield()
    printWithThread("end")
}

suspend fun newRoutine() { /** suspend fun: 다른 suspend fun을 호출할 수 있다. ex) yield() */
    val num1 = 1
    val num2 = 2
    yield() /** yield(): 지금 코루틴을 중단하고 다른 코루틴이 실행되도록 한다. (스레드를 양보한다) */
    printWithThread("${num1+ num2}")
}

fun printWithThread(str: String) {
    println("[${Thread.currentThread().name}] $str")
}