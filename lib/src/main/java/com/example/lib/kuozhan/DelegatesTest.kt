package com.example.lib.kuozhan

import kotlin.properties.Delegates

/**
 * 使用Delegates.observable实现观察者模式
 * 使用Delegates.vetoable实现拦截功能
 */
class DelegatesTest {

    private var observableProp: String by Delegates.observable("init value 0") { property, oldValue, newValue ->
        println("change $property, $oldValue -> $newValue")
    }

    fun test() {
        print(observableProp)
        observableProp = "hello world"
    }

    // 实现双机退出
    private var backPressedTime by Delegates.observable(0L) { _, oldValue, newValue ->
        if (newValue - oldValue > 200) {
            // TODO: 2022/6/29 两次点击时间超过200
        } else {
            // TODO: 2022/6/29 再点击一次退出
        }
    }

    fun clickBack() {
        backPressedTime = System.currentTimeMillis()
    }

    // 拦截
    private var num by Delegates.vetoable(0) { _, oldValue, newValue ->
        return@vetoable newValue <= oldValue
    }
}