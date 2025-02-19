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
import com.gopalpoddar4.kubuddy.Adapter.PYQAdapter
import com.gopalpoddar4.kubuddy.Interface.OnChildItemClickListner
import com.gopalpoddar4.kubuddy.Models.ChildModel
import com.gopalpoddar4.kubuddy.Models.ParentModel
import com.gopalpoddar4.kubuddy.R


class PYQFragment : Fragment(),OnChildItemClickListner {

    lateinit var pyqRecyclerView: RecyclerView
    lateinit var pyqList:ArrayList<ParentModel>
    lateinit var pyqAsapter:PYQAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_p_y_q, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().window.decorView.systemUiVisibility=
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION

        val PYQback = view.findViewById<ImageView>(R.id.pyqBack)
        PYQback.setOnClickListener(){
            findNavController().navigateUp()
        }

        pyqRecyclerView=view.findViewById(R.id.PYQRecyclerview)
        pyqRecyclerView.layoutManager=LinearLayoutManager(context)

        pyqList= arrayListOf()

        pyqAsapter= PYQAdapter(pyqList,this)
        pyqRecyclerView.adapter=pyqAsapter
    }

    override fun onChildItemClick(item: ChildModel) {
        findNavController().navigate(R.id.action_PYQFragment_to_pdfFragment)
    }


}