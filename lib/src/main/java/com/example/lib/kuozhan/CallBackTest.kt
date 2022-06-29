package com.example.lib.kuozhan

import com.example.lib.CallBack

class CallBackTest {
    private val callBack = object : CallBack {
        override fun back() {

        }
    }

    fun callBackTest() {
        test(callBack)
    }

    fun test(callBack: CallBack) {
        callBack.back()
    }
}