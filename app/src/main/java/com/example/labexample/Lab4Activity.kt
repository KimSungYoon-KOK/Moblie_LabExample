package com.example.labexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import com.example.labexample.myrecyclerview.MyActivity
import kotlinx.android.synthetic.main.activity_lab4.*

class Lab4Activity : AppCompatActivity() {

    val checkbox = mutableListOf<CheckBox>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab4)
        init()
    }

    fun init() {

        checkbox.add(checkBox)
        checkbox.add(checkBox2)
        checkbox.add(checkBox3)
        checkbox.add(checkBox4)
        checkbox.add(checkBox5)
        checkbox.add(checkBox6)
        checkbox.add(checkBox7)
        checkbox.add(checkBox8)
        checkbox.add(checkBox9)
        checkbox.add(checkBox10)

        for(check in checkbox) {
            check.setOnCheckedChangeListener { buttonView, isChecked ->
                val imgID = resources.getIdentifier(buttonView.text.toString(), "id", packageName)
                val imgView = findViewById<ImageView>(imgID)

                if(isChecked)
                    imgView.visibility = View.VISIBLE
                else
                    imgView.visibility = View.INVISIBLE
            }
        }


        gotoLab3.setOnClickListener{
            val intent = Intent(this, CustomWidgetActivity::class.java)
            startActivity(intent)
            finish()
        }

        gotoLab5.setOnClickListener{
            val intent = Intent(this, MyActivity::class.java)
            startActivity(intent)
            finish()
        }

    }




}
