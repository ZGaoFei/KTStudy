package com.example.lib


// 定义类
class FirstKT {

    fun main(): Unit {
        // TODO: 3/14/22
        TODO()
        TODO("hello world")
        return
    }

    fun main(args: Array<String>) {
        test()

        first("hello world")

        println(backData(1, 2))
        var data = backData2(2, 3)
        println(data)
        data = backData3(3, 4)
        println(data)

        vars(1, 2, 3, 4)

        // lambda（匿名函数）
        val sumLambda: (Int, Int) -> Int = { x, y -> x + y }
        println(sumLambda(3, 4))

        testString()
    }

    // 定义方法
    fun test() {
        print("test")
    }

    // 定义开参数方法
    fun first(a: String) {
        println(a)
    }

    // 定义带返回值的方法
    fun backData(a: Int, b: Int): Int {
        return a + b
    }

    fun backData2(a: Int, b: Int) = a + b

    fun backData3(a: Int, b: Int): Int = a + b

    // 可变长度参数
    fun vars(vararg list: Int) {
        for (a in list) {
            println(a)
        }
    }

    /*
     * 注释
     /*
     有一个注释
     */
     */
    fun vaTest() {
        var a = 1
        a = 4
        var b: Int = 3
        var c: Int

        val d: Int = 4
        // d = 5
    }

    /*
    $ 符匹配变量
    ${} 匹配方法返回值
     */
    fun testString() {
        val str = "world"
        var hw = "hello $str"
        println(hw)

        var str2 = "${hw.replace("o", "e")}, current is $hw"
        println(str2)

        val a = """
            ${'$'}9.99
        """
        println(a)
    }

    // null检查
    /**
     * ?   可为空
     * !!. 为空抛空指针异常
     * ?.  为空不调用
     * ?:  做空判断处理，为空的话就返回冒号后面的值
     */
    fun nullCheck() {
        // 可以为空
        var a: String? = "haha" // null

        // a为空，则抛异常，
        var b = a!!.toString()
        println(b)

        // a为空，则不调用toString()方法
        var c = a?.toString()
        println(c)

        // a为空，则返回hehe
        var d = a?.toString() ?: "hehe"
        println(d)
    }

    fun nullBack(): Int? {
        var a = 0
        var b = 1
        var c = null
//        return a + b
        return c
    }

    // is = instanceof
    fun isTest(obj: Any): Int? {
        if (obj is String) {
            return obj.length
        }
        return null
    }

    fun isTest1(obj: Any): Int? {
        if (obj !is String) {
            return null
        }
        return obj.length
    }

    /**
     * 区间
     * ..     区间
     * step   步数，每隔step输出
     * downTo 倒叙
     * util   排除最后一位
     */
    fun range() {
        for (i in 1..5) { // 相当于i >= 1 && i <= 5
            print(i)
        }
        println()

        for (i in 5..1) { // 什么也不输出
            print(i)
        }
        println()

        for (i in 1..5 step 3) { // step步长，输出14
            print(i)
        }
        println()

        for (i in 5 downTo 1) { // downTo 倒叙
            print(i)
        }
        println()

        for (i in 5 downTo 1 step 2) { // 输出531
            print(i)
        }
        println()

        for (i in 1 until 10) { // [1,10)
            print(i)
        }
        println()
    }

    // 基本数据类型，每一个基本数据类型都是一个对象
    fun base() {
        val a: Int = 1
        val c: Float = 2.0f
        val b: Double = 3.0
        val e: Short = 4
        val f: Long = 5L
        val g: Byte = 6
    }

    /**
     * ==   比较值是否相同
     * ===  比较地址是否相同
     */
    fun compare(a: Int, b: Int) {
        if (a == b) {
            println("a == b")
        } else {
            println("a != b")
        }

        if (a === b) {
            println("a is b")
        } else {
            println("a is not b")
        }

        val c = 1000
        // 装箱的过程值相等，但不是同一个对象
        val d: Int? = c
        val e: Int? = c
        if (d == e) {
            println("d == e")
        } else {
            println("d != e")
        }
        if (d === e) {
            println("d is e")
        } else {
            println("d is not e")
        }
    }

    // 类型转换
    fun to() {
        var a = 1000
        a.toByte()
        a.toString()
        a.toChar()
        a.toDouble()
        a.toFloat()
        a.toInt()
        a.toLong()
        a.toShort()

        var b: Double = 2.0
        // 不同的类型不能相互转换，可以用上面的to***方法转
        // a = b
        // b = a

        // 数学操作符会重载
        var c = a + b
        var d = 2L + 3.0
    }

    // 操作符，只有Int和Long有
    fun operation() {
        val a: Int = 1000
        a.shl(2) // 左移位 (Java’s <<)
        a.shr(2) // 右移位 (Java’s >>)
        a.ushr(2) // 无符号右移位 (Java’s >>>)
        a.and(2)  // 与
        a.or(2) // 或
        a.xor(2) // 异或
        a.inv() // 反向
    }

    // char
    fun charTest() {
        val a = 'a'
        val b: Char = 'b'
        // if (a == 1) // 不可以直接和数字进行操作

        var c = '\n'
        c = '\t'
        c = '\b'
        c = '\r'
        c = '\\'
        c = '\$'

        val d = '1'
        if (d in '0'..'9') {
            val i = d.toInt() - '0'.toInt() // 显式转换为数字
            println(i)
        }
    }

    fun booleanTest() {
        val a: Boolean = true
        val b: Boolean = false
        if (a || b) {

        }
        if (a && b) {

        }
        if (!a) {

        }
        // if (a & b)
    }

    // 数组
    fun array() {
        val a = arrayOf(1, 2, 3)
        print(a[1])
        println()
        for (b in a) {
            print(b)
        }
        println()
        val b = Array(3, { i -> i + 1 })
        print(b[2])
        println()
        for (c in b) {
            print(c)
        }
        println()

        val e: IntArray = intArrayOf(1, 2, 3)
        // var f = StringArray()
        // f.add("hello")

        val stringArray = arrayOf("hello", "world")
    }

    // 字符串
    fun string() {
        val s = "hello world"
        println(s[3])

        for (a in s) {
            print(a)
        }
        println()

        val s3 = """
                 hello 
            |world
        """
        println(s3)
        // 默认 | 用作边界前缀，但你可以选择其他字符并作为参数传入，比如 trimMargin(">")
        println(s3.trimMargin())
    }

    // 条件语句
    fun ifTest(obj: Any): Int {
        val a = 1
        val b = 2

        val c = if (a < b) a else b // 类似Java的三元运算符

        if (a in 1..9) {

        }

        // 相当于switch
        when (obj) {
            1 -> print(1)
            2, 3 -> print("2,3")
            is String -> print("is String")
            in 1..10 -> print("1.。10")
            !in 0..1 -> print("!0..1")
            else -> {
                print("else")
            }
        }

        if (a < b)
            return a
        return b
    }

    // 循环语句
    fun forTest() {
        val items = arrayOf("a", "b", "c")
        for (item in items) {
            print(item)
        }
        println()
        for (i in items.indices) {
            print(items[i])
        }
        println()

        var i = 0
        while (i < items.size) {
            print(items[i])
            i++
        }
        println()

        var j = 0
        do {
            print(items[j])
            j++
        } while (j < items.size)
        println()

        for (x in 1..10) {
            for (y in 1..10) {
                val z = x + y
                if (z == 15)
                //continue
                    break
                print("$z ")
            }
            println()
        }

        loop@ for (x in 1..10) {
            for (y in 1..10) {
                val z = x + y
                if (z == 15)
                    continue@loop
                //break@loop
                print("$z ")
            }
            println()
        }
    }

    fun testKuoZhan() {
        BaseInterKT().test(1, 2)

         // BaseInterKT().print()
    }
}