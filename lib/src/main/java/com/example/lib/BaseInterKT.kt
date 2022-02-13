package com.example.lib

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class BaseInterKT(a: Int) : BaseKT(a), Base {
    // 重写属性
    override val b: Int
        get() = super.b

    override var c: Int = 0

    constructor() : this(0) {

    }

    override fun test(a: Int, b: Int): Int {
        //super<BaseKT>.test(a, b)
        //super<Base>.test(a, b)

        return 0
    }

    override fun test1() {
        TODO("Not yet implemented")
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>) {

    }

    var name : String by Delegates.observable("初始值") {
        property, oldValue, newValue ->
        print("$oldValue == $newValue")
    }

}