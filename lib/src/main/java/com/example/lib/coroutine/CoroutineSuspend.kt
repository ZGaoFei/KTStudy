package com.example.lib.coroutine

import kotlinx.coroutines.*

class CoroutineSuspend {

    @DelicateCoroutinesApi
    fun test1() {
        doLog("coroutine suspend test")
        GlobalScope.launch {
            doLog("coroutine suspend test1")
            val arg1 = suspendTest1()
            val arg2 = suspendTest2()

            doLog("suspend finish arg1:$arg1  arg2:$arg2  result:${arg1 + arg2}")
        }
    }

    private suspend fun suspendTest1(): Int {
        delay(1000)
        doLog("suspend test 1")

        return 2
    }

    private suspend fun suspendTest2(): Int {
        delay(1000)
        doLog("suspend test 2")

        return 4
    }

    private fun doLog(str: String) {
        println(str)
    }

    private val scope = GlobalScope

    fun asyncTest() {
        scope.launch {
            val one = async {
                delay(1000)
                "1"
            }

            val two = async {
                delay(1000)
                "2"
            }

            val three = async {
                delay(1000)
                "3"
            }

            print("${one.await()}, ${two.await()}, ${three.await()}")
        }

    }
}