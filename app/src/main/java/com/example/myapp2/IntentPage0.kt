package com.example.myapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony.Sms.Intents
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class IntentPage0 : AppCompatActivity(), View.OnClickListener {
    lateinit var ed1:EditText
    lateinit var ed2:EditText
    lateinit var turnBt:Button
    lateinit var clearBt:Button
    private lateinit var imageView1: ImageView
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
    var currentImgID = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_page0)

        /// 绑定
        ed1 = findViewById(R.id.ed1)
        ed2 = findViewById(R.id.ed2)
        turnBt = findViewById(R.id.turn1)
        clearBt = findViewById(R.id.clear1)
        imageView1 = findViewById(R.id.iv1)

        randAImgWhenStart() // 每次进入 Activity 时随机选择图片

        turnBt.setOnClickListener(this)
        clearBt.setOnClickListener(this)

    }

    //打开Activity时候随机选择图片
    private fun randAImgWhenStart() {
        var rndNum = (0..24).random()
//        Toast.makeText(this,"RandNum: $rndNum, ImgID: ${imgID[rndNum]}", Toast.LENGTH_SHORT).show()
        //imageView1.setImageResource(R.drawable.wx1001)
        imageView1.setImageResource(R.drawable.cat10)
        currentImgID = rndNum
        imageView1.setImageResource(imgID[rndNum])
//        imageBottomTextSignal.setText("这是第${currentImgID}张图")
    }

    override fun onClick(p0: View?) {
//        TODO("Not yet implemented")
        when (p0?.id) {
            R.id.turn1 -> {
                var acc = Intent(this, IntentPage1::class.java)
                acc.putExtra("Name",ed1.text.toString());
                acc.putExtra("PhoneNumber",ed2.text.toString());
                acc.putExtra("imgID", currentImgID)
                println(currentImgID)
                startActivity(acc)
                randAImgWhenStart()

            }


            R.id.clear1 -> {
                ed1.setText("")
                ed2.setText("")
            }

        }
    }
}