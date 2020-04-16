package com.example.labexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_lab2.*

class Lab2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab2)
        init()
    }

    fun init(){
        emailText.addTextChangedListener(object :TextWatcher{
            
        })
    }
}
