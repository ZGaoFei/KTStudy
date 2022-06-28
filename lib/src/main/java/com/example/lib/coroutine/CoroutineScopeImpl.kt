package com.example.lib.coroutine

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class CoroutineScopeImpl(override val coroutineContext: CoroutineContext) : CoroutineScope {

    fun test01() {
        val launch = launch {
            delay(1000)
            println("hello world")
        }
        launch.cancel()
    }

    suspend fun test02() {
        val async = async {
            delay(1000)
            println("hello world")
        }
        async.await()
    }

    fun test03() {
        launch {
            val async = async {
                delay(100)
                print("delay 100")
                100
            }
            val async1 = async {
                delay(300)
                print("delay 300")
                300
            }

            val sum = async.await() + async1.await()
            println("sum : $sum")

            // async.cancel()
        }
    }

    suspend fun test04() {
        coroutineScope {

        }
    }

    fun test05() = run { 3 }
}