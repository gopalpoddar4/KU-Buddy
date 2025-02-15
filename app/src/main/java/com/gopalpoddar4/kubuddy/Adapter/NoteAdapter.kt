package com.gopalpoddar4.kubuddy.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gopalpoddar4.kubuddy.Models.NoteModel
import com.gopalpoddar4.kubuddy.R

class NoteAdapter(private val notes:List<NoteModel>):RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val subjectName:TextView=itemView.findViewById(R.id.rcv_item_subject_name)
        var childRCV:RecyclerView=itemView.findViewById(R.id.childRCV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rcv_item_layout,parent,false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

        holder.subjectName.text = notes[position].subjectName
        if (notes[position].isExpanded){
            holder.childRCV.visibility=View.VISIBLE
            holder.childRCV.layoutManager=LinearLayoutManager(holder.itemView.context)
            holder.childRCV.adapter=NoteChildAdapter(notes[position].itemList)
        }else{

            holder.childRCV.visibility=View.GONE
        }
        holder.subjectName.setOnClickListener(){
            notes[position].isExpanded=!notes[position].isExpanded
            notifyItemChanged(position)
        }
    }
}