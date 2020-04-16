package com.example.labexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.MultiAutoCompleteTextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val countries = mutableListOf(
        "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra",
        "Angola", "Auguilla", "Antarctica"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init() {
        countries2 = resources.getStringArray(R.array.countries_array)
        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            countries2
        )
        autoCompleteTextView.setAdapter(adapter)

        multiAutoCompleteTextView.setAdapter(adapter)
        multiAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())

        editText.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                val str = s.toString()
                inputBtn.isEnabled = str.isNotEmpty()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            //    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            //    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })

        inputBtn.setOnClickListener {
            adapter.add(editText.text.toString())
        }
    }
}
