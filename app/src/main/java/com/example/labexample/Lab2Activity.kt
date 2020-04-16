package com.example.labexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
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
            override fun afterTextChanged(s: Editable?) {
                if(s.toString().contains("@")){
                    textInputLayout.error = null
                }else{
                    textInputLayout.error = "이메일 형식이 올바르지 않습니다."
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
               // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
               // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

        gotoLab1.setOnClickListener{
            val intent = Intent(this, AutoCompleteActivity::class.java)
            startActivity(intent)
            finish()
        }

        gotoLab3.setOnClickListener{
            val intent = Intent(this, CustomWidgetActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
