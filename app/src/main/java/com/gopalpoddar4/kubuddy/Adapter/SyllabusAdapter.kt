package com.gopalpoddar4.kubuddy.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gopalpoddar4.kubuddy.Interface.OnChildItemClickListner
import com.gopalpoddar4.kubuddy.Models.ChildModel
import com.gopalpoddar4.kubuddy.Models.ParentModel
import com.gopalpoddar4.kubuddy.R

class SyllabusAdapter(private val syllabus:List<ParentModel>,private val listner: OnChildItemClickListner):RecyclerView.Adapter<SyllabusAdapter.SyllabusViewHolder>(){

    class SyllabusViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val subjectName: TextView =itemView.findViewById(R.id.rcv_item_subject_name)
        var childRCV:RecyclerView=itemView.findViewById(R.id.childRCV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SyllabusViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rcv_item_layout,parent,false)
        return SyllabusViewHolder(view)
    }

    override fun getItemCount(): Int {
        return syllabus.size
    }

    override fun onBindViewHolder(holder: SyllabusViewHolder, position: Int) {
        var temp:ParentModel=syllabus[position]
        holder.subjectName.text = temp.subjectName

        if (temp.isExpanded){
            holder.childRCV.visibility=View.VISIBLE
            holder.childRCV.layoutManager=LinearLayoutManager(holder.itemView.context)
            holder.childRCV.adapter=SyllabusChildAdapter(temp.itemList,listner)

        }else{
            holder.childRCV.visibility=View.GONE
        }
        holder.subjectName.setOnClickListener(){
            temp.isExpanded=!temp.isExpanded
            notifyItemChanged(position)
        }
    }
}