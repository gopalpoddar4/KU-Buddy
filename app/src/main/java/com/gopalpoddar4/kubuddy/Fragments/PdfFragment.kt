package com.gopalpoddar4.kubuddy.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.gopalpoddar4.kubuddy.R
import java.net.URLEncoder

class PdfFragment : Fragment() {
lateinit var webView: WebView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_pdf, container, false)

        webView=view.findViewById(R.id.webview)

        webView.settings.javaScriptEnabled = true  // JavaScript enable karega
        webView.settings.allowFileAccess = true    // File access allow karega
        webView.settings.domStorageEnabled = true

        val pdfurl="https://drive.google.com/file/d/1PvlkxLk2YKsiIjCm_NMa5F0sPIUwfXgV/preview"


        webView.loadUrl(pdfurl)
        return view
    }
}