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
import com.gopalpoddar4.kubuddy.Adapter.IQAdapter
import com.gopalpoddar4.kubuddy.Interface.OnChildItemClickListner
import com.gopalpoddar4.kubuddy.Models.ChildModel
import com.gopalpoddar4.kubuddy.Models.ParentModel
import com.gopalpoddar4.kubuddy.R


class ImportantQuestionFragment : Fragment(),OnChildItemClickListner {

    lateinit var iqRecyclerView: RecyclerView
    lateinit var iqList:ArrayList<ParentModel>
    lateinit var iqAdapter:IQAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_important_question, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().window.decorView.systemUiVisibility=
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION

        val IqBack=view.findViewById<ImageView>(R.id.IQBack)
        IqBack.setOnClickListener(){
            findNavController().navigateUp()
        }
        iqRecyclerView=view.findViewById(R.id.IQRecyclerview)
        iqRecyclerView.layoutManager=LinearLayoutManager(context)

        iqList= arrayListOf()

        iqAdapter = IQAdapter(iqList,this)
        iqRecyclerView.adapter=iqAdapter
    }

    override fun onChildItemClick(item: ChildModel) {
        findNavController().navigate(R.id.action_importantQuestionFragment_to_pdfFragment)
    }


}