package com.example.lib.kuozhan

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * 属性委托
 */
class ValueDelegation {
    var delegateProp by MyDelegate()

    fun main(args: Array<String>) {

    }
}

class MyDelegate {
    operator fun getValue(valueDelegation: ValueDelegation, property: KProperty<*>): Any {
        return "MyDelegate get $valueDelegation ${property.name}"
    }

    operator fun setValue(valueDelegation: ValueDelegation, property: KProperty<*>, any: Any) {
        println("MyDelegate set $any $valueDelegation ${property.name}")
    }
}

// 将Any转换为String
class MyDelegate1 : ReadWriteProperty<Any, String> {

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        println("MyDelegate set $value $thisRef ${property.name}")
    }

    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        return "MyDelegate get $thisRef ${property.name}"
    }
}

object Prop {
    @JvmStatic
    var encodeProp:String by EncodeProperty("init")
}

class EncodeProperty(var value: String) : ReadWriteProperty<Any, String> {

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        this.value = value
        println("save encode prop $value")
    }

    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        return "get encode prop output $value"
    }

}