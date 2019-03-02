package com.example.recyclercardview

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myView.setOnClickListener(){
            Toast.makeText(this,"btn clicked",Toast.LENGTH_SHORT).show()

            val myIntent = Intent(this,HobbiesActivity::class.java)
            startActivity(myIntent)
        }
    }
}
