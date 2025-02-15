package com.gopalpoddar4.kubuddy.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.gopalpoddar4.kubuddy.R


class PYQFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_p_y_q, container, false)

        val PYQback = view.findViewById<ImageView>(R.id.pyqBack)
        PYQback.setOnClickListener(){
            findNavController().navigateUp()
        }

        return view
    }


}