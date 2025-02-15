package com.gopalpoddar4.kubuddy.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gopalpoddar4.kubuddy.Models.ChildModel
import com.gopalpoddar4.kubuddy.R

class NoteChildAdapter(private val items:List<ChildModel>):RecyclerView.Adapter<NoteChildAdapter.ChildViewHolder>() {

    class ChildViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val childName:TextView=itemView.findViewById(R.id.childSubjectName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chilc_rcv_layout, parent, false)
        return ChildViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        holder.childName.text=items[position].subjectName
    }
}