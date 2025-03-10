package com.gopalpoddar4.kubuddy.Fragments

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gopalpoddar4.kubuddy.Adapter.NoteRecommendAdapter
import com.gopalpoddar4.kubuddy.Models.RecommendModel
import com.gopalpoddar4.kubuddy.R


class HomeFragment : Fragment() {
    lateinit var rcvRecomendNote:RecyclerView
lateinit var noteButton:CardView
lateinit var updateButton:CardView
lateinit var syllabusButton:CardView
lateinit var QuestionButton:CardView
lateinit var TaskButton:CardView
lateinit var VideoButton:CardView
lateinit var ExamNewsButton:CardView
lateinit var PYQButton:CardView

lateinit var recomendNoteAdapter:NoteRecommendAdapter
lateinit var recomendNoteModel: RecommendModel
lateinit var noteList: ArrayList<RecommendModel>

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
       VideoButton=view.findViewById(R.id.videoButton)
        ExamNewsButton=view.findViewById(R.id.examNewsButton)
        PYQButton=view.findViewById(R.id.pyqButton)
        var userName=view.findViewById<TextView>(R.id.userName)
        var userCourse=view.findViewById<TextView>(R.id.userCourse)
        var userSemester=view.findViewById<TextView>(R.id.userSemester)

        val sharedPreferences = requireContext().getSharedPreferences("login",android.content.Context.MODE_PRIVATE)
        val firstname = sharedPreferences.getString("firstname","User")
        val lastName = sharedPreferences.getString("lastname","Name")
        val course = sharedPreferences.getString("course","Bsc.IT")
        val semester = sharedPreferences.getString("semesterString","2")

        userName.text=firstname+" "+lastName
        userCourse.text=course
        userSemester.text="Semester "+semester

        val settingBtn = view.findViewById<ImageView>(R.id.settingButton)
        settingBtn.setOnClickListener(){
            findNavController().navigate(R.id.action_homeFragment_to_settingFragment)
        }
        VideoButton.setOnClickListener(){
            findNavController().navigate(R.id.action_homeFragment_to_videoFragment)
        }
        ExamNewsButton.setOnClickListener(){
            findNavController().navigate(R.id.action_homeFragment_to_examNewsFragment)
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
            RecommendModel(R.drawable.pic1,"English"),
            RecommendModel(R.drawable.pic2,"Hindi"),
            RecommendModel(R.drawable.pic3,"Science"),
            RecommendModel(R.drawable.pic4,"Biology")
        )
        recomendNoteAdapter=NoteRecommendAdapter(noteList)

        rcvRecomendNote.adapter=recomendNoteAdapter

        return view
    }


}