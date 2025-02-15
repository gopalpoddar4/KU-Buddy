package com.gopalpoddar4.kubuddy.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gopalpoddar4.kubuddy.Adapter.NoteRecommendAdapter
import com.gopalpoddar4.kubuddy.Models.NoteModel
import com.gopalpoddar4.kubuddy.Models.RecomendNoteModel
import com.gopalpoddar4.kubuddy.R


class HomeFragment : Fragment() {
    lateinit var rcvRecomendNote:RecyclerView
lateinit var noteButton:CardView
lateinit var updateButton:CardView
lateinit var syllabusButton:CardView
lateinit var QuestionButton:CardView
lateinit var TaskButton:CardView
lateinit var ExamDateButton:CardView
lateinit var ExamNewsButton:CardView
lateinit var PYQButton:CardView

lateinit var recomendNoteAdapter:NoteRecommendAdapter
lateinit var recomendNoteModel: RecomendNoteModel
lateinit var noteList: ArrayList<RecomendNoteModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_home, container, false)

        noteButton=view.findViewById(R.id.noteButton)
        syllabusButton=view.findViewById(R.id.syllabusButton)
        rcvRecomendNote=view.findViewById(R.id.rcvRecomendNote)
        updateButton=view.findViewById(R.id.updateButton)
        QuestionButton=view.findViewById(R.id.questionButton)
        TaskButton=view.findViewById(R.id.taskButton)
        ExamDateButton=view.findViewById(R.id.examDateButton)
        ExamNewsButton=view.findViewById(R.id.examNewsButton)
        PYQButton=view.findViewById(R.id.pyqButton)

        val settingBtn = view.findViewById<ImageView>(R.id.settingButton)
        settingBtn.setOnClickListener(){
            findNavController().navigate(R.id.action_homeFragment_to_settingFragment)
        }

        updateButton.setOnClickListener(){
            findNavController().navigate(R.id.action_homeFragment_to_updateFragment)
        }
        PYQButton.setOnClickListener(){
            findNavController().navigate(R.id.action_homeFragment_to_pdfFragment)
        }
        QuestionButton.setOnClickListener(){
            findNavController().navigate(R.id.action_homeFragment_to_importantQuestionFragment)
        }

        noteButton.setOnClickListener(){
            findNavController().navigate(R.id.action_homeFragment_to_notesFragment)
        }

        syllabusButton.setOnClickListener(){
            findNavController().navigate(R.id.action_homeFragment_to_syllabusFragment)
        }

        val noteViewall=view.findViewById<TextView>(R.id.noteViewAll)
        noteViewall.setOnClickListener(){
            findNavController().navigate(R.id.action_homeFragment_to_notesFragment)
        }

        rcvRecomendNote.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

        noteList= arrayListOf(
            RecomendNoteModel(R.drawable.pic1,"English"),
            RecomendNoteModel(R.drawable.pic2,"Hindi"),
            RecomendNoteModel(R.drawable.pic3,"Science"),
            RecomendNoteModel(R.drawable.pic4,"Biology")
        )
        recomendNoteAdapter=NoteRecommendAdapter(noteList)

        rcvRecomendNote.adapter=recomendNoteAdapter


        return view
    }


}