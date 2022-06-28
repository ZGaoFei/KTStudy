package com.example.lib.delegation

/**
 * 类委托
 *
 * 实现代理模式
 */
class ClassDelegation {

    fun testDelegation() {
        val myDB = MyDB(SQL())
        myDB.addData()
        myDB.delData()
        myDB.queryData()
    }

    fun testDelegation3() {
        MyDB3().addData()
    }
}

class MyDB(private val persistence: IDataPersistence) : IDataPersistence by persistence

class MyDB2(private val delegation: IDataPersistence) : IDataPersistence by delegation {

    override fun addData() {
        delegation.addData()
    }
}

class MyDB3 : IDataPersistence by SQL()

interface IDataPersistence {
    fun addData()
    fun delData()
    fun queryData()
}

class SQL : IDataPersistence {

    override fun addData() {
        print("SQL add data")
    }

    override fun delData() {
        print("SQL del data")
    }

    override fun queryData() {
        print("SQL query data")
    }
}

class SP : IDataPersistence {

    override fun addData() {
        print("SP add data")
    }

    override fun delData() {
        print("SP del data")
    }

    override fun queryData() {
        print("SP query data")
    }
}