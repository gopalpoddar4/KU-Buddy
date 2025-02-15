package com.gopalpoddar4.kubuddy.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gopalpoddar4.kubuddy.Adapter.NoteAdapter.NoteViewHolder
import com.gopalpoddar4.kubuddy.Models.SyllabusModel
import com.gopalpoddar4.kubuddy.R

class SyllabusAdapter(private val syllabus:List<SyllabusModel>):RecyclerView.Adapter<SyllabusAdapter.SyllabusViewHolder>(){

    class SyllabusViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val subjectName: TextView =itemView.findViewById(R.id.rcv_item_subject_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SyllabusViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rcv_item_layout,parent,false)
        return SyllabusViewHolder(view)
    }

    override fun getItemCount(): Int {
        return syllabus.size
    }

    override fun onBindViewHolder(holder: SyllabusViewHolder, position: Int) {
        holder.subjectName.text = syllabus[position].subjectName
    }
}