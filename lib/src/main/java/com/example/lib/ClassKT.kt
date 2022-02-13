package com.example.lib

import com.example.lib.ClassKT.Back as Back1

// 主构造函数
class ClassKT constructor(string: String = "") : BaseKT(0) {

    var string: String = ""
        get() = "class"
        set

    var i: Int = 1
        get() = field
        set(value) {
            if (value < 10) {
                field = 10
            } else {
                field = 0
            }
        }

    var height: String ?= ""
        private set

    // 延迟初始化
    lateinit var with: String

    private var a: Int = 0
    var d = "外部成员"

    init {
        print("在这里初始化")
    }

    // 次构造函数
    constructor(string: String = "a", i: Int = 0) : this(string) {

    }

    fun a() {

    }

    // 嵌套类
    class InnerClass {
        fun foo() = 2
    }

    fun InnerClass.print() {
        print("扩展函数")
    }

    fun testInnerClass() {
        InnerClass().foo()

        InnerClass().print()
    }

    fun BaseInterKT.print() {
        print("输出扩展函数")
    }

    // 扩展属性
    val BaseInterKT.c
        get() = 2

    fun testKuoZhan() {
        BaseInterKT().test(1, 2)

        BaseInterKT().print()

        BaseInterKT().c
    }

    // 内部类，持有外部类的引用，用inner标注
    inner class Inner {
        fun foo() = a

        fun innerTest() {
            var i = b

        }

        fun innerTest1() {
            var i = this@ClassKT
            print(i.b)
        }
    }

    fun testCallBack() {
        setBack(object : Back {
            override fun back() {
                TODO("Not yet implemented")
            }
        })
    }

    fun setCallBack(callBack: CallBack) {
        callBack.back()
    }

    fun setBack(back: Back) {
        back.back()
    }

    interface Back {
        fun back()
    }
}
