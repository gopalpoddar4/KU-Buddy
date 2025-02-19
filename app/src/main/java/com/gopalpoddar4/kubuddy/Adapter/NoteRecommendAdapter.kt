package com.gopalpoddar4.kubuddy.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gopalpoddar4.kubuddy.Models.RecommendModel
import com.gopalpoddar4.kubuddy.R

class NoteRecommendAdapter (private val recomendNote:List<RecommendModel>):RecyclerView.Adapter<NoteRecommendAdapter.RecomendNoteViewModel>(){

    class RecomendNoteViewModel(itemView:View):RecyclerView.ViewHolder(itemView){
        val subjectName:TextView=itemView.findViewById(R.id.rcv_recomend_subject_name)
        val subjectImage:ImageView=itemView.findViewById(R.id.rcv_recomend_subject_logo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecomendNoteViewModel {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rcv_recommend_item_layout,parent,false)
        return RecomendNoteViewModel(view)
    }

    override fun getItemCount(): Int {
       return recomendNote.size
    }

    override fun onBindViewHolder(holder: RecomendNoteViewModel, position: Int) {
         holder.subjectName.text=recomendNote[position].subject
        holder.subjectImage.setImageResource(recomendNote[position].image)
    }
}