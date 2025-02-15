package com.gopalpoddar4.kubuddy.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gopalpoddar4.kubuddy.Adapter.NoteAdapter
import com.gopalpoddar4.kubuddy.Adapter.SyllabusAdapter
import com.gopalpoddar4.kubuddy.Models.NoteModel
import com.gopalpoddar4.kubuddy.Models.SyllabusModel
import com.gopalpoddar4.kubuddy.R


class SyllabusFragment : Fragment() {
    lateinit var syllabusRecyclerView: RecyclerView
   lateinit var syllabusList:ArrayList<SyllabusModel>
    lateinit var syllabusAdapter: SyllabusAdapter
    lateinit var syllabusBack: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_syllabus, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().window.decorView.systemUiVisibility=
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION

        syllabusBack=view.findViewById(R.id.syllabusBack)
        syllabusBack.setOnClickListener {
            findNavController().navigateUp()
        }

        syllabusRecyclerView=view.findViewById(R.id.syllabusRecyclerview)
        syllabusRecyclerView.layoutManager= LinearLayoutManager(context)
        syllabusList= arrayListOf(
            SyllabusModel("Digital Education"),
            SyllabusModel("Hindi"),
            SyllabusModel("English"),
            SyllabusModel("EDP"),
            SyllabusModel("Political Science"),
            SyllabusModel("History"),
            SyllabusModel("Secience"),
            SyllabusModel("Physics"),
            SyllabusModel("Biology"),
            SyllabusModel("Math"),
            SyllabusModel("Digital Education"),

            )
        syllabusAdapter= SyllabusAdapter(syllabusList)
        syllabusRecyclerView.adapter=syllabusAdapter
    }


}