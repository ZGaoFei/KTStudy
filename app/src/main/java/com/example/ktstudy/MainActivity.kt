package com.example.ktstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lib.FirstKT

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        test()
    }

    private fun test() {
        FirstKT().backData(1, 2)

        FirstKT().vars(1, 2, 3, 4)

        val firstKT = FirstKT()
        firstKT.testString()
    }
}