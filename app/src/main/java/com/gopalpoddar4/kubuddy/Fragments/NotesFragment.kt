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
import com.gopalpoddar4.kubuddy.Models.ChildModel
import com.gopalpoddar4.kubuddy.Models.NoteModel
import com.gopalpoddar4.kubuddy.R


class NotesFragment : Fragment() {

    lateinit var noteRecyclerView:RecyclerView
    lateinit var noteList: ArrayList<NoteModel>
    lateinit var noteAdapter: NoteAdapter
    lateinit var noteBack:ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_notes, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().window.decorView.systemUiVisibility=
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION


        noteBack = view.findViewById(R.id.noteBack)
        noteBack.setOnClickListener {
            findNavController().navigateUp()
        }

        noteRecyclerView = view.findViewById(R.id.noteRecyclerview)
        noteRecyclerView.layoutManager = LinearLayoutManager(context)

        noteList= arrayListOf(
            NoteModel("Bsc IT", listOf(
                ChildModel("C Programming ( Major )"),
                ChildModel("Computer Application"),
                ChildModel("Digital Education"),
                ChildModel("Yoga"),
                ChildModel("EVS"),
                ChildModel("Hindi"),
                ChildModel("Understanding India")
            )),

            NoteModel("BCA", listOf(
                ChildModel("Computer Application"),
                ChildModel("Digital Education"),
                ChildModel("Yoga"),
                ChildModel("EVS"),
                ChildModel("Hindi"),
                ChildModel("Understanding India")
            )),

            NoteModel("BBA", listOf(
                ChildModel("Digital Education"),
                ChildModel("Yoga"),
                ChildModel("EVS"),
                ChildModel("Hindi"),
                ChildModel("Understanding India")
            )),

            NoteModel("Math", listOf(
                ChildModel("Digital Education"),
                ChildModel("Yoga"),
                ChildModel("EVS"),
                ChildModel("Hindi"),
                ChildModel("Understanding India")
            )),

            NoteModel("History", listOf(
                ChildModel("Digital Education"),
                ChildModel("Yoga"),
                ChildModel("EVS"),
                ChildModel("Hindi"),
                ChildModel("Understanding India")
            )),

            NoteModel("Physics", listOf(
                ChildModel("Digital Education"),
                ChildModel("Yoga"),
                ChildModel("EVS"),
                ChildModel("Hindi"),
                ChildModel("Understanding India")
            )),

            NoteModel("Chemistry", listOf(
                ChildModel("Digital Education"),
                ChildModel("Yoga"),
                ChildModel("EVS"),
                ChildModel("Hindi"),
                ChildModel("Understanding India")
            ))



        )

        noteAdapter = NoteAdapter(noteList)
        noteRecyclerView.adapter=noteAdapter
    }
}