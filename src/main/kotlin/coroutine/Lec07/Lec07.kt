package com.example.coroutine.Lec07

import com.example.printWithThread
import kotlinx.coroutines.*

suspend fun main() {
    CoroutineName("나만의 코루틴") + Dispatchers.Default
    val job = CoroutineScope(Dispatchers.Default).launch {
        delay(1000L)
        printWithThread("job")
    }

    job.join()

    val asyncLogic = AsyncLogic()
    asyncLogic.doSomething()

    asyncLogic.destroy()
}

class AsyncLogic {
    private val scope = CoroutineScope(Dispatchers.Default)

    fun doSomething() {
        scope.launch {
            // job..
        }
    }

    fun destroy() {
        scope.cancel()
    }
}