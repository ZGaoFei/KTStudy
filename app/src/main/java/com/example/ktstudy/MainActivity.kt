package com.example.ktstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.ktstudy.list.ListActivity
import com.example.lib.FirstKT
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private val scope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        test()
    }

    private fun initView() {
        val testSuspendBt = findViewById<Button>(R.id.bt_test_suspend1);
        testSuspendBt.setOnClickListener(View.OnClickListener {
            testSuspend()
        })

        findViewById<Button>(R.id.bt_test_suspend2).setOnClickListener(View.OnClickListener {
            testSuspend1()
        })

        findViewById<Button>(R.id.bt_skip_list_page).setOnClickListener(View.OnClickListener {
            ListActivity.start(this)
        })
    }

    private fun test() {
        FirstKT().backData(1, 2)

        FirstKT().vars(1, 2, 3, 4)

        val firstKT = FirstKT()
        firstKT.testString()
    }

    private fun testSuspend() {
        scope.launch {
            val one = async {
                delay(1000)
                "1"
            }

            val two = async {
                delay(1000)
                "2"
            }

            val three = async {
                delay(1000)
                "3"
            }

            Log.e("zgf", "${one.await()}, ${two.await()}, ${three.await()}")
        }
    }

    private fun testSuspend1() {
        GlobalScope.launch {
            val arg1 = suspendTest1()
            val arg2 = suspendTest2()

            Log.e("zgf", "suspend finish arg1:$arg1  arg2:$arg2  result:${arg1 + arg2}")
        }
    }

    private suspend fun suspendTest1(): Int {
        delay(1000)
        Log.e("zgf", "suspend test 1")

        return 2
    }

    private suspend fun suspendTest2(): Int {
        delay(1000)
        Log.e("zgf", "suspend test 2")

        return 4
    }
}