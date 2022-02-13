package com.example.lib

open class BaseKT(a: Int) {

    open val b: Int = 0

    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun sum() {

    }

    fun sum(a: Int) {

    }

    open fun test(a: Int, b: Int): Int {
        if (a > b) {
            return a
        }
        return b
    }
}