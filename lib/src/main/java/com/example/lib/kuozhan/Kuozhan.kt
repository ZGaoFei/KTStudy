package com.example.lib.kuozhan

/**
 * 常用扩展函数
 *
 * let
 * also
 * with
 * apply
 * run
 * takeIf
 * takeUnless
 * repeat
 */
class Kuozhan {

    fun letTest() {
        val string = "hello world";
        val let = string.let {
            val startsWith = it.startsWith("h")
            it.length
        }

        string?.let {
            it.toString()
            it.length
            it.count()
        }
    }

    class User(val name: String, val age: Int) {
        var height = 0
        var sex = "男"

        fun printWith() {
            print("name: $name, age: $age, height: $height, sex: $sex")
        }
    }
    fun withTest() {
        val withClass = User("name", 18)
        val with = with(withClass, {
            printWith()
            print("name: $name, age: $age, height: $height, sex: $sex")
            name.length
        })

        with(withClass) {
            printWith()
            print("name: $name, age: $age, height: $height, sex: $sex")
            name.length
        }
    }

    fun runTest() {
        val runClass = User("name", 18)
        val run = runClass.run {
            printWith()
            print("name: $name, age: $age, height: $height, sex: $sex")
            name.length
        }

        runClass?.run {

        }
    }

    fun applyTest() {
        val applyClass = User("name", 18)
        val apply = applyClass?.apply {
            printWith()
            print("name: $name, age: $age, height: $height, sex: $sex")
            name.length
        }
        apply.printWith()
    }

    fun alsoTest() {
        val alsoClass = User("name", 18)
        val also = alsoClass?.also {
            it.printWith()
            print("name: $it.name, age: $it.age, height: $it.height, sex: $it.sex")
            it.name.length
        }
        also.printWith()
    }

    fun takeTest() {
        val takeClass = User("name", 18)
        val takeIf = takeClass.takeIf {
            it.name.length > 10
        }

        takeClass.takeUnless {
            it.name.length > 10
        }
    }

    fun repeatTest() {
        repeat(5) {
            print(it)
        }
    }
}