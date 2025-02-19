package com.gopalpoddar4.kubuddy.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.gopalpoddar4.kubuddy.Interface.OnChildItemClickListner
import com.gopalpoddar4.kubuddy.Models.ParentModel
import com.gopalpoddar4.kubuddy.R

class PYQAdapter(private val pyq:List<ParentModel>,private val listner: OnChildItemClickListner):RecyclerView.Adapter<PYQAdapter.PYQViewHolder>() {

class PYQViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    val subjectName: TextView =itemView.findViewById(R.id.rcv_item_subject_name)
    var childRCV:RecyclerView=itemView.findViewById(R.id.childRCV)
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PYQViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rcv_item_layout,parent,false)
        return PYQViewHolder(view)
    }

    override fun getItemCount(): Int {
       return pyq.size
    }

    override fun onBindViewHolder(holder: PYQViewHolder, position: Int) {
       val temp:ParentModel = pyq[position]

        holder.subjectName.text=temp.subjectName
        if (temp.isExpanded){
            holder.childRCV.visibility=View.VISIBLE
            holder.childRCV.layoutManager= LinearLayoutManager(holder.itemView.context)
            holder.childRCV.adapter=PYQChildAdapter(temp.itemList,listner)
        }else{
            holder.childRCV.visibility=View.GONE
        }

        holder.subjectName.setOnClickListener(){
            temp.isExpanded=!temp.isExpanded
            notifyItemChanged(position)
        }
    }


}