package com.example.lib.coroutine

import kotlinx.coroutines.*
import kotlin.math.log
import kotlin.system.*

class CoroutineTest01 {

    fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

    fun test01() = GlobalScope.launch {
        delay(1000)
        println("World")
        log("world")
    }

    fun test02() = runBlocking {
        GlobalScope.launch {
            delay(1000)
            println("world")
        }
        println("hello")
        delay(2000)
    }

    suspend fun test03() {
        val launch = GlobalScope.launch {
            delay(1000)
            println("world")
        }
        println("hello")
        launch.join()
    }

    fun test04() = runBlocking {
        val launch = launch {
            delay(1000)
            print("world")
        }
        launch.join()
    }

    fun test05() = runBlocking {
        launch {
            delay(2000)
            println("world")
        }

        coroutineScope {
            launch {
                delay(1000)
                println("hello")
            }

            delay(2000)
            println("200")
        }

        delay(300)
        println("300")
    }

    private suspend fun delayTest01(): Int {
        delay(100)
        return 10
    }

    private suspend fun delayTest02(): Int {
        delay(200)
        return 30
    }

    suspend fun test06() = measureTimeMillis {
        val delayTest01 = delayTest01()
        val delayTest02 = delayTest02()
        println("sum is ${delayTest01 + delayTest02}")
    }

    suspend fun test07() = runBlocking<Unit> {
        val sum = measureTimeMillis {
            val delayTest01 = delayTest01()
            val delayTest02 = delayTest02()
            println("two num sum is ${delayTest01 + delayTest02}")
        }
        println("sum is $sum")
    }

    suspend fun test08() = runBlocking<Unit> {
        val time = measureTimeMillis {
            val one = async { delayTest01() }
            val two = async { delayTest02() }

            // one.start()
            println("The answer is ${one.await() + two.await()}")
        }
        println("Completed in $time ms")
    }

    suspend fun test09() = runBlocking<Unit> {
        val time = measureTimeMillis {
            val one = async(start = CoroutineStart.LAZY) { delayTest01() }
            val two = async(start = CoroutineStart.LAZY) { delayTest02() }

            one.start()
            two.start()
            println("The answer is ${one.await() + two.await()}")
        }
        println("Completed in $time ms")
    }

}