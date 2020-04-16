package com.example.labexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.MultiAutoCompleteTextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val countries = mutableListOf(
        "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra",
        "Angola", "Auguilla", "Antarctica", "Antigua and Barbuda", "Argentina",
        "Armenia", "Aruba", "Australia", "Austraia", "Azerbaijan", "Bahrain",
        "Bangladesh", "Barbados", "Belarus", "Belgium"
    )

    lateinit var adapter: ArrayAdapter<String>
    lateinit var countries2: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init() {

        //autoCompleteTextView
//        adapter = ArrayAdapter<String>(
//            this,
//            android.R.layout.simple_dropdown_item_1line,
//            countries
//        )

//        autoCompleteTextView.setOnItemClickListener{
//            parent, view, position, id ->
//            val item = parent.getItemAtPosition(position).toString()
//            Toast.makeText(this, "선택된 항목 : $item", Toast.LENGTH_SHORT).show()
//        }

        //MultiAutoCompleteTextView
        countries2 = resources.getStringArray(R.array.countries_array)
        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            countries
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
            adapter.notifyDataSetChanged()
            editText.text.clear()
        }
    }
}
