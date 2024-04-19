package com.example.myapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MyIntentList1 : AppCompatActivity() {
    lateinit var textView1: TextView
    lateinit var imageView1: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_intent_list1)
        textView1 = findViewById(R.id.ed1)
        imageView1 = findViewById(R.id.iv1)

        var imgsIDs = intArrayOf(R.drawable.surprised, R.drawable.expression, R.drawable.strange)
        var listContent = arrayListOf("google", "tel:23434", "nnutc")
        var mySimpleMap: ArrayList<Map<String, Any>> = ArrayList()
        for (i in listContent.indices) {
            var item = HashMap<String, Any>()
            item["itemPic"] = imgsIDs[i]
            item["itemStyle"] = listContent[i]
            mySimpleMap.add(item)
        }
        var from = arrayListOf("itemPic", "itemStyle")
//        var to = intArrayOf(R.id.imgView1, R.id.)
//        var myWebSimpleAdap = SimpleAdapter(this, mySimpleMap, R.id.tv2, from, to)
    }
}