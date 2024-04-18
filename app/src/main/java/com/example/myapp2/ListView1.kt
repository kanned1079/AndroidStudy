package com.example.myapp2

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class ListView1 : AppCompatActivity() {
    lateinit var myColorlist: ListView
    lateinit var myStylelist: ListView
    lateinit var myText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view1)

        myColorlist = findViewById(R.id.listview1)
        myStylelist = findViewById(R.id.listview2)
        myText = findViewById(R.id.tv1)

        var colors = arrayListOf("红", "绿", "蓝")
        myColorlist.choiceMode = 1
        var myColorAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, colors)
        myColorlist.adapter = myColorAdapter
        myColorlist.setOnItemClickListener { adapterView, view, i, l ->
            var colorSelect = myColorlist.getItemAtPosition(i)
            myColorlist.getItemAtPosition(i)
            println(colorSelect)
            when (colorSelect) {
                "红" -> myText.setTextColor(Color.RED)
                "绿" -> myText.setTextColor(Color.GREEN)
                "蓝" -> myText.setTextColor(Color.BLUE)
            }
        }

        var styles = arrayListOf("粗体", "斜体")
        myStylelist.choiceMode = 2
        var myStyleAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, styles)
        myStylelist.adapter = myStyleAdapter
        myStylelist.setOnItemClickListener { adapterView, view, i, l ->
            var styleSelect = myStylelist.getItemAtPosition(i)
            println(styleSelect)
            var isBoldSelected = false
            var isItalicSelected = false
            var textStyle = myText.typeface.style
            when (i) {
                0 ->  textStyle = textStyle.xor(1)
                1 -> textStyle = textStyle.xor(2)
            }
            myText.setTypeface(Typeface.create(myText.typeface, textStyle)) // 得用这个
//            myText.setTypeface(null, textStyle) // 这个不行
        }

    }

}





