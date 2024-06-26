package com.example.myapp2

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import android.widget.Toast

class ListView1 : AppCompatActivity() {
    lateinit var myColorlist: ListView
    lateinit var myStylelist: ListView
    lateinit var newsLists: ListView
    lateinit var myText: TextView
//    lateinit var myText2: TextView
    lateinit var myImageview1 :ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view1)

        myColorlist = findViewById(R.id.listview1)
        myStylelist = findViewById(R.id.listview2)
        newsLists = findViewById(R.id.listview3)
        myText = findViewById(R.id.tv1)

//        myImageview1 = findViewById(R.id.imgView1)
//        myText2 = findViewById(R.id.ed2)

        // 这里是listView1
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

        // 这里是listView2的
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

        // 这里开始是listView3的内容
        var imgsIDs = arrayOf<Int>(R.drawable.surprised, R.drawable.expression, R.drawable.strange)
        var listContent = arrayListOf<String>("跳转到计算器", "跳转到网页", "跳转到电话")
        var btList = arrayOf("按钮1", "按钮2", "按钮3")
        var newsList: ArrayList<Map<String, Any>> = ArrayList()
        for (i in listContent.indices) {
            var item = HashMap<String, Any>()
            item["itemPic"] = imgsIDs[i]
            item["itemStyle"] = listContent[i]
            item["itemBtn"] = btList[i]
            newsList.add(item)
        }
        var from = arrayOf("itemPic", "itemStyle", "itemBtn")
        var to = intArrayOf(R.id.iv_new_image, R.id.tv_news_title, R.id.iv_news_btn)
        var mySimpleAdapter:SimpleAdapter = SimpleAdapter(this, newsList, R.layout.news, from, to)
        // 如果要点击里面的按钮那就不能用SimpleAdapter
        newsLists.adapter = mySimpleAdapter

        newsLists.setOnItemClickListener { adapterView, view, i, l ->
            when(i) {
//                Toast.makeText(this, i.toString(), Toast.LENGTH_SHORT).show()
                //
                0 -> {
                    // 显式Intent 跳转到Calculator
                    var toCal = Intent(this, Calculator::class.java)
                    startActivity(toCal)}
                1 -> {
                    var toWeb = Intent(Intent.ACTION_VIEW, Uri.parse("https://ikanned.com:55444/"))
                    startActivity(toWeb)
                }
                2 -> {
//                    var toCall_120 = Intent(Intent.ACTION_CALL)
//                    toCall_120.setData(Uri.parse("tel:120")
//                    var toCall_120 = Intent(Intent.ACTION_CALL, Uri.parse("tel:120")) // 这里如果用CALL需要开启权限
                    var toCall_120 = Intent(Intent.ACTION_DIAL, Uri.parse("tel:120")) // 可以用这个

                    startActivity(toCall_120)
                }

            }
        }

    }

}





