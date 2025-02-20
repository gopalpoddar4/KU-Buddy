package com.gopalpoddar4.kubuddy

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)

        val imageView=findViewById<ImageView>(R.id.splash_image)

        val animation :Animation=AnimationUtils.loadAnimation(this,R.anim.splash_animation)
        imageView.startAnimation(animation)


        Handler(Looper.getMainLooper()).postDelayed({

            val sharedPreferences=getSharedPreferences("login", MODE_PRIVATE)
            val value:Boolean=sharedPreferences.getBoolean("flag",false)
            if (value){
                val intent=Intent(this,MainActivity::class.java)
                startActivity(intent)
            }else{
                val intent=Intent(this,Login::class.java)
                startActivity(intent)
            }
            finish()
        },2000)
    }
}