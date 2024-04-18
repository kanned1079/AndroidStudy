package com.example.myapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class MainActivityuuuu2 : AppCompatActivity() ,View.OnClickListener {

    private lateinit var bigBtn:Button
    private lateinit var smallbtn:Button
    private lateinit var circBtn:Button
    private lateinit var preImbtn:ImageButton
    private lateinit var latterBtn:ImageButton
    private lateinit var imageView1:ImageView
    private lateinit var randGenerateImageBtn:Button
    private lateinit var imageBottomTextSignal:TextView
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
        setContentView(R.layout.activity_main_activityuuuu2)

        bigBtn = findViewById(R.id.bt1)
        smallbtn = findViewById(R.id.bt2)
        circBtn = findViewById(R.id.bt3)
        imageView1 = findViewById(R.id.iv1)
        preImbtn = findViewById(R.id.ibt1)
        latterBtn = findViewById(R.id.ibt2)
        randGenerateImageBtn = findViewById(R.id.bt0)
        imageBottomTextSignal = findViewById(R.id.tv0)

        bigBtn.setOnClickListener(this)
        smallbtn.setOnClickListener(this)
        circBtn.setOnClickListener(this)
        preImbtn.setOnClickListener(this)
        latterBtn.setOnClickListener(this)
        randGenerateImageBtn.setOnClickListener(this)


        randAImgWhenStart()
    }

    //打开Activity时候随机选择图片
    fun randAImgWhenStart() {
        var rndNum = (1..9).random()
        Toast.makeText(this,"RandNum: $rndNum, ImgID: ${imgID[rndNum]}", Toast.LENGTH_SHORT).show()
        //imageView1.setImageResource(R.drawable.wx1001)
        imageView1.setImageResource(R.drawable.cat10)
        currentImgID = rndNum
        imageView1.setImageResource(imgID[rndNum])
        imageBottomTextSignal.setText("这是第${currentImgID}张图")
    }

    override fun onClick(p0: View?) {
//        TODO("Not yet implemented")
//        val params:LinearLayout.LayoutParams= LinearLayout.LayoutParams(imageView1.width + 10,imageView1.height + 10)
        when (p0?.id) {
            R.id.bt1 -> {
//                放大
                var margin: ViewGroup.MarginLayoutParams = ViewGroup.MarginLayoutParams(imageView1.getLayoutParams())
                margin.leftMargin = 230
                margin.topMargin = 60
                var newScale:LinearLayout.LayoutParams = LinearLayout.LayoutParams(margin)
                newScale.height = imageView1.height + 10
                newScale.width = imageView1.width + 10
                // val params:LinearLayout.LayoutParams= LinearLayout.LayoutParams(imageView1.width + 10,imageView1.height + 10)
                imageView1.setLayoutParams(newScale)

            }
            R.id.bt2 -> {
//                缩小
                var margin: ViewGroup.MarginLayoutParams = ViewGroup.MarginLayoutParams(imageView1.getLayoutParams())
                margin.leftMargin = 230
                margin.topMargin = 60
                var newScale:LinearLayout.LayoutParams = LinearLayout.LayoutParams(margin)
                newScale.height = imageView1.height - 10
                newScale.width = imageView1.width - 10
                // val params:LinearLayout.LayoutParams= LinearLayout.LayoutParams(imageView1.width - 10,imageView1.height - 10)
                imageView1.setLayoutParams(newScale)
            }
            R.id.bt3 -> {
//                旋转
                imageView1.rotation = imageView1.rotation + 15
            }
            R.id.bt0 -> {
                //                随机数
                var rndNum = (1..9).random()
                Toast.makeText(this,"RandNum: $rndNum, ImgID: ${imgID[rndNum]}", Toast.LENGTH_SHORT).show()
                //imageView1.setImageResource(R.drawable.wx1001)
                imageView1.setImageResource(R.drawable.cat10)
                currentImgID = rndNum
                imageView1.setImageResource(imgID[rndNum])
                imageBottomTextSignal.setText("这是第${rndNum}张图")
            }
            R.id.ibt1 -> {
//                前一张
                if (currentImgID == 1) {
                    Toast.makeText(this, "已经是第一张了", Toast.LENGTH_SHORT).show()
                } else {
                    currentImgID -= 1
                    imageView1.setImageResource(imgID[currentImgID])
                    imageBottomTextSignal.setText("这是第${currentImgID}张图")

                }
            }
            R.id.ibt2 -> {
//                后一张
                if (currentImgID == 25) {
                    Toast.makeText(this, "已经是最后一张了", Toast.LENGTH_SHORT).show()
                    currentImgID = 25
                } else {
                    currentImgID += 1
                    imageView1.setImageResource(imgID[currentImgID] - 1)
                    imageBottomTextSignal.setText("这是第${currentImgID}张图")

                }

            }
        }
    }


}