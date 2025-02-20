package com.gopalpoddar4.kubuddy

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)


        val firstName1 = findViewById<TextInputEditText>(R.id.enterFirstName)
        val lastName1 = findViewById<TextInputEditText>(R.id.enterLastName)
        val course1 = findViewById<TextInputEditText>(R.id.enterCourse)
        val semester1 = findViewById<TextInputEditText>(R.id.enterSemester)
        val continueButton = findViewById<Button>(R.id.continueButton)

        val sharedPreferences=getSharedPreferences("login", MODE_PRIVATE)
        val editor=sharedPreferences.edit()

        continueButton.setOnClickListener{
            val firstName = firstName1.text.toString()
            val lastName = lastName1.text.toString()
            val course = course1.text.toString()
            val semester2 = semester1.text.toString()
            val semester = semester2.toIntOrNull()?:1

           if (firstName.isNotEmpty() && lastName.isNotEmpty() && course.isNotEmpty() && semester2.isNotEmpty() && semester>0){

               editor.putString("firstname",firstName)
               editor.putString("lastname",lastName)
               editor.putString("course",course)
               editor.putBoolean("flag",true)
               editor.putString("semesterString",semester2)
               editor.putInt("semester",semester)
               editor.apply()

               val view=LayoutInflater.from(applicationContext).inflate(R.layout.book_anim_layout,null)
               val builder=AlertDialog.Builder(this, com.google.android.material.R.style.ThemeOverlay_Material3_Dialog)
               builder.setView(view)
               builder.setCancelable(false)
               val dialog=builder.create()

              val letgoname = view.findViewById<TextView>(R.id.letsgoname)
               letgoname.text="Welcome $firstName"

               val letsgobutton = view.findViewById<TextView>(R.id.letsgobutton)
               letsgobutton.text="Let's Go $firstName"

               letsgobutton.setOnClickListener{
                   val intent = Intent(this, MainActivity::class.java)
                   startActivity(intent)
                   finish()
               }

               dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
               dialog.show()
           }else{
               Toast.makeText(this,"Enter all details",Toast.LENGTH_SHORT).show()
           }
        }

    }
}