package com.gopalpoddar4.kubuddy.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gopalpoddar4.kubuddy.Adapter.SyllabusAdapter
import com.gopalpoddar4.kubuddy.Interface.OnChildItemClickListner
import com.gopalpoddar4.kubuddy.Models.ChildModel
import com.gopalpoddar4.kubuddy.Models.ParentModel
import com.gopalpoddar4.kubuddy.R


class SyllabusFragment : Fragment(),OnChildItemClickListner {

    lateinit var syllabusRecyclerView: RecyclerView
   lateinit var syllabusList:ArrayList<ParentModel>
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
                ParentModel("Common Subject For All", arrayListOf(
                    ChildModel("English ( AEC )","1PvlkxLk2YKsiIjCm_NMa5F0sPIUwfXgV"),
                    ChildModel("News Writing & Reporting","1PvlkxLk2YKsiIjCm_NMa5F0sPIUwfXgV"),
                    ChildModel("Communication Skill & Per. Dev.","1PvlkxLk2YKsiIjCm_NMa5F0sPIUwfXgV")
                ))
            )
            syllabusAdapter= SyllabusAdapter(syllabusList,this)
            syllabusRecyclerView.adapter=syllabusAdapter


        }

    override fun onChildItemClick(item: ChildModel) {
        val action=SyllabusFragmentDirections.actionSyllabusFragmentToPdfFragment(item)
        findNavController().navigate(action)
    }


}