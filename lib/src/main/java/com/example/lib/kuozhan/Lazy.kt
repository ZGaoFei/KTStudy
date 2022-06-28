package com.example.lib.kuozhan

class Lazy {

    fun lazyTest1(): String {
        val string: String by lazy {
            "hello world"
        }
        return string
    }

    fun lazyTest2() {
        val string: String by lazy {
            ->
            ""
        }
    }

    fun lazyTest3() {
        val string: String by lazy("hello") {
            "hello world"
        }
    }

    fun lazyTest4() {
        val string: String by lazy(LazyThreadSafetyMode.NONE) {
            "hello world"
        }
    }

    lateinit var str: String
    fun lateInitTest() {
        if (::str.isLateinit) {
            print(str)
        }
        str = "hello world"
        print(str)
    }
}