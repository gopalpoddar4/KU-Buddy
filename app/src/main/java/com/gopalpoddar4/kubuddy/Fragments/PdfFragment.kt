package com.gopalpoddar4.kubuddy.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.gopalpoddar4.kubuddy.Models.ChildModel
import com.gopalpoddar4.kubuddy.R
import java.net.URLEncoder

class PdfFragment : Fragment() {

lateinit var webView: WebView
lateinit var pdfKeyId:String
lateinit var pdfName:String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_pdf, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pdfData:ChildModel=PdfFragmentArgs.fromBundle(requireArguments()).pdf
        pdfName=pdfData.subjectName
        pdfKeyId=pdfData.PDF_ID

        val PdfName=view.findViewById<TextView>(R.id.pdfName)
        PdfName.text=pdfName

        val pdfBack = view.findViewById<ImageView>(R.id.pdfBack)
        pdfBack.setOnClickListener(){
            findNavController().navigateUp()
        }

        webView=view.findViewById(R.id.webview)

        webView.settings.javaScriptEnabled = true  // JavaScript enable karega
        webView.settings.allowFileAccess = true    // File access allow karega
        webView.settings.domStorageEnabled = true


        val pdfurl="https://drive.google.com/file/d/$pdfKeyId/preview"

        webView.loadUrl(pdfurl)
    }
}