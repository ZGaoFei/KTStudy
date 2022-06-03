package com.example.ktstudy.list

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ktstudy.R

class ListAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val typeOne: Int = 0
    private val typeTwo: Int = 1

    private var data: ArrayList<Data>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0) {
            val view = LayoutInflater.from(context).inflate(R.layout.layout_item_one, parent, false)
            ListOneHolder(view)
        } else {
            val view = LayoutInflater.from(context).inflate(R.layout.layout_item_two, parent, false)
            ListTwoHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ListOneHolder) {
            val itemData = data?.get(position) as ItemData
            holder.tvTitle.text = itemData.title
            holder.tvContent.text = itemData.content
        } else if (holder is ListTwoHolder) {
            val itemData = data?.get(position) as Item2Data
            holder.tvTitle.text = itemData.title
        }
    }

    override fun getItemCount(): Int {
        var count = 0
        if (data != null) {
            count = data?.size!!
        }
        return count
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) typeOne else typeTwo
    }

    fun update(data: ArrayList<Data>?) {
        if (this.data == null) {
            this.data = ArrayList()
        }
        if (data != null) {
            this.data?.addAll(data)
            notifyDataSetChanged()
        }
    }

    class ListOneHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tv_one_title)
        val tvContent: TextView = view.findViewById(R.id.tv_one_content)
    }

    class ListTwoHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tv_two_title)
    }

}