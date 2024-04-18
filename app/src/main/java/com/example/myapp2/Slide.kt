package com.example.myapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.RatingBar
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlin.math.log
import kotlin.math.log10

class Slide : AppCompatActivity(), RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener {
    lateinit var maleSelectBtn:RadioButton
    lateinit var femaleSelectBtn:RadioButton
    lateinit var myGenderGroup:RadioGroup
    lateinit var logViewText:TextView
    var myHabits = ""
    lateinit var swimming:CheckBox
    lateinit var running:CheckBox
    lateinit var sleeping:CheckBox
    lateinit var chooseYear:Spinner
    lateinit var chooseMonth:Spinner
    lateinit var myStars:RatingBar
    // 定義數組
    var myMonths:Array<String> = arrayOf("一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide)

        maleSelectBtn = findViewById(R.id.male)
        femaleSelectBtn = findViewById(R.id.female)
        logViewText = findViewById(R.id.logs)
        myGenderGroup = findViewById(R.id.genderGroup)

        myGenderGroup.setOnCheckedChangeListener(this)

        swimming = findViewById(R.id.swim)
        running = findViewById(R.id.run)
        sleeping = findViewById(R.id.sleep)

        chooseYear = findViewById(R.id.ch1)
        chooseMonth = findViewById(R.id.ch2)

        myStars = findViewById(R.id.comment0)

//        sleeping.setOnCheckedChangeListener(selectHabits())
        running.setOnCheckedChangeListener(selectHabits())
        swimming.setOnCheckedChangeListener(selectHabits())
        sleeping.setOnClickListener(myClick())

        chooseYear.onItemSelectedListener = spinner1()


        var myMonthAdp = ArrayAdapter(this, android.R.layout.simple_list_item_1, myMonths)
        chooseMonth.adapter = myMonthAdp // 綁定適配器
        chooseMonth.onItemSelectedListener = monthSelect() // 綁定事件監聽器

        myStars.setOnRatingBarChangeListener { ratingBar, fl, b ->
            println(fl)
            Toast.makeText(this, fl.toString(), Toast.LENGTH_SHORT).show()
        }

    }

    // 接口
    override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
        when(p1) {
            R.id.male -> {
                println("you choosed male gender")
                logViewText.text = "male"
                Toast.makeText(this, "male", Toast.LENGTH_SHORT).show()
            }
            R.id.female -> {
                logViewText.text = "female"
                p0?.let{
                    Snackbar.make(it, "female", Snackbar.LENGTH_SHORT).setAction("退出", View.OnClickListener { println("aaaaaa") }).show()
                }
            }
        }
    }

    // 内部类
    inner class selectHabits: CompoundButton.OnCheckedChangeListener {
        override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
//            TODO("Not yet implemented")
            if (swimming.isChecked) {
                myHabits += "游泳 "
                logViewText.text = myHabits
            }
            if (running.isChecked) {
                myHabits += "跑步 "
                logViewText.text = myHabits
            }
            if (sleeping.isChecked) {
                myHabits += "睡觉 "
                logViewText.text = myHabits
            }
        }
    }

    inner class myClick: View.OnClickListener {
        override fun onClick(p0: View?) {
            myHabits = ""
            if (swimming.isChecked) {
                myHabits += "游泳 "
                logViewText.text = myHabits
            }
            if (running.isChecked) {
                myHabits += "跑步 "
                logViewText.text = myHabits
            }
            if (sleeping.isChecked) {
                myHabits += "睡觉 "
                logViewText.text = myHabits
            }
        }
    }

    // p174
    // 這個使用的是適配器
    inner class spinner1: AdapterView.OnItemSelectedListener {
        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            Toast.makeText(applicationContext, chooseYear.getItemAtPosition(p2).toString(), Toast.LENGTH_SHORT).show()
        }

        override fun onNothingSelected(p0: AdapterView<*>?) {
//            TODO("Not yet implemented")
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    inner class monthSelect:OnItemSelectedListener {
        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//            TODO("Not yet implemented")
            Toast.makeText(applicationContext, chooseMonth.getItemAtPosition(p2).toString(), Toast.LENGTH_SHORT).show()

        }

        override fun onNothingSelected(p0: AdapterView<*>?) {
            TODO("Not yet implemented")
        }
    }

}