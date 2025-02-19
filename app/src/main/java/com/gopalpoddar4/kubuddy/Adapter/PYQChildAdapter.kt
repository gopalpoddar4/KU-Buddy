package com.gopalpoddar4.kubuddy.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.gopalpoddar4.kubuddy.Interface.OnChildItemClickListner
import com.gopalpoddar4.kubuddy.Models.ChildModel
import com.gopalpoddar4.kubuddy.R

class PYQChildAdapter(private val items:List<ChildModel>, private val listner: OnChildItemClickListner):RecyclerView.Adapter<PYQChildAdapter.ChildViewHolder>() {

    class ChildViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val childName: TextView =itemView.findViewById(R.id.childSubjectName)
        val layoout: CardView =itemView.findViewById(R.id.ChildLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chilc_rcv_layout, parent, false)
        return ChildViewHolder(view)
    }

    override fun getItemCount(): Int {
       return items.size
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        val temp:ChildModel=items[position]
        holder.childName.text=temp.subjectName
        holder.layoout.setOnClickListener{listner.onChildItemClick(temp)}
    }
}