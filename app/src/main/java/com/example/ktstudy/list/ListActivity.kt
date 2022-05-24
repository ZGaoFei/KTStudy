package com.example.ktstudy.list

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ktstudy.R

class ListActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var adapter: ListAdapter? = null
    private var data: ArrayList<Data>? = null

    // 静态方法
    companion object {
        @JvmStatic
        fun start(context: Context) {
            context.startActivity(Intent(context, ListActivity().javaClass))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        initData()
        initView()
    }

    private fun initData() {
        data = ArrayList()

        for (i in 0..9) {
            if (i % 2 == 0) {
                val itemData = ItemData("title $i", "content $i")
                data?.add(itemData)
            } else {
                val itemData2 = Item2Data("item $i")
                data?.add(itemData2)
            }
        }
    }

    private fun initView() {
        val button = findViewById<Button>(R.id.bt_update)
        button.setOnClickListener {
            adapter?.update(data)
        }
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        adapter = ListAdapter(this)
        recyclerView?.adapter = adapter
    }
}