package com.example.myapp2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class IntentPage1 : AppCompatActivity(), View.OnClickListener {
//    lateinit var tv1:TextView
//    lateinit var tv2:TextView
    lateinit var back:Button
    lateinit var myList:ListView

    var imgID = intArrayOf(
        R.drawable.cat1,
        R.drawable.cat2,
        R.drawable.cat3,
        R.drawable.cat4,
        R.drawable.cat5,
        R.drawable.cat6,
        R.drawable.cat7,
        R.drawable.cat8,
        R.drawable.cat9,
        R.drawable.cat10,
        R.drawable.cat11,
        R.drawable.cat12,
        R.drawable.cat13,
        R.drawable.cat14,
        R.drawable.cat15,
        R.drawable.cat16,
        R.drawable.cat17,
        R.drawable.cat18,
        R.drawable.cat19,
        R.drawable.cat20,
        R.drawable.cat21,
        R.drawable.cat22,
        R.drawable.cat23,
        R.drawable.cat24,
        R.drawable.cat25
    )

    companion object {
        // 这里是存Name字段的
        var i = 0
        var nameArr = arrayOfNulls<String>(20)
        var phoneArr = arrayOfNulls<String>(20)
        var imgIdArr = IntArray(20) // 存储图片资源ID的数组
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_page1)

        // 绑定
//        tv1 = findViewById(R.id.tv1)
//        tv2 = findViewById(R.id.tv2)
        back = findViewById(R.id.back1)
        myList = findViewById(R.id.infoList)

        val myIntent = this.intent

        // 获取name字段
        var name = myIntent.getStringExtra("Name")
//        tv1.text = name

        // 获取phoneNumber字段
        var phoneNum = myIntent.getStringExtra("PhoneNumber")
//        tv2.text = phoneNum

        if (!isNameUnique(name.toString())) {
            Toast.makeText(this, "姓名重复", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        if (!isValidPhoneNumber(phoneNum.toString())) {
            Toast.makeText(this, "手机号不合法", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        // 获取图片ID
        var imgNum = myIntent.getIntExtra("imgID", 0)

        imgIdArr[i] = imgID[imgNum] // 将图片ID加入数组
        // 将获取到的Name和phoneNum字段加入数组nameArr
        nameArr[i] = name
        phoneArr[i++] = phoneNum

        // 定义Map kv
        var mySimpleMap:ArrayList<Map<String, Any>> = ArrayList()

        for(m in 0 until i) {
            var item = HashMap<String, Any>()
//            item.put("list_img", imgID) // 添加头像资源ID到Map
            item.put("list_img", imgIdArr[m]) // 添加头像资源ID到Map
            item.put("list_name", nameArr[m].toString())
            item.put("list_phone", phoneArr[m].toString()) // 添加手机号到Map
            mySimpleMap.add(item)
        }
//        var from = arrayOf("list_name")
        var from = arrayOf("list_img", "list_name", "list_phone")
        var to = intArrayOf(R.id.personImg_space, R.id.list_name_space, R.id.list_phone_space)
        var myRegister_simpleAdp = SimpleAdapter(this, mySimpleMap, R.layout.layout_half_test, from, to)
        myList.adapter = myRegister_simpleAdp

        myList.setOnItemClickListener { adapterView, view, position, id ->
            val phoneNumber = phoneArr[position]
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$phoneNumber")
            startActivity(intent)
        }

        back.setOnClickListener(this)

    }

    // 检查姓名是否重复
    private fun isNameUnique(name: String): Boolean {
        return name !in nameArr
    }

    // 检查手机号是否合法
    private fun isValidPhoneNumber(phoneNumber: String): Boolean {
        return phoneNumber.matches(Regex("\\d{11}"))
    }

    override fun onClick(p0: View?) {
//        TODO("Not yet implemented")
        when (p0?.id) {
            R.id.back1 -> finish()
        }
    }
}