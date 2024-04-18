package com.example.myapp2

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner

class SlideWork : AppCompatActivity(), RadioGroup.OnCheckedChangeListener {
    lateinit var ed1:EditText
    lateinit var colorSelection:RadioGroup
    lateinit var boldCheck:CheckBox
    lateinit var xieCheck:CheckBox
    lateinit var selectSize:Spinner
    val intArray = IntArray(21)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slide_work)
        ed1 = findViewById(R.id.ed1)
        colorSelection = findViewById(R.id.colorGroup)
        boldCheck = findViewById(R.id.boldBtn)
        xieCheck = findViewById(R.id.xieBtn)
        selectSize = findViewById(R.id.chSize)
        // 設置動作
        colorSelection.setOnCheckedChangeListener(this)

        for (i in intArray.indices) {
            intArray[i] = i + 20
        }

        val stringArray = Array(intArray.size) { "" }

        for (i in intArray.indices) {
            stringArray[i] = intArray[i].toString() // 將 int 數組中的數字轉換為 string 存入 string 數組
        }

        var fontSizeAdp = ArrayAdapter(this, android.R.layout.simple_list_item_1, stringArray)
        selectSize.adapter = fontSizeAdp
        selectSize.onItemSelectedListener = fontSelectioner()

        boldCheck.setOnCheckedChangeListener(chooseFontType())
        xieCheck.setOnCheckedChangeListener(chooseFontType())

    }

    fun updateTextStyle() {
        val isBold = boldCheck.isChecked
        val isItalic = xieCheck.isChecked

        var textStyle = Typeface.NORMAL
        if (isBold && isItalic) {
            textStyle = Typeface.BOLD_ITALIC
        } else if (isBold) {
            textStyle = Typeface.BOLD
        } else if (isItalic) {
            textStyle = Typeface.ITALIC
        }

        ed1.setTypeface(null, textStyle)
    }

    inner class chooseFontType: CompoundButton.OnCheckedChangeListener {
        override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
//            TODO("Not yet implemented")
            updateTextStyle()
        }
    }

    inner class fontSelectioner: AdapterView.OnItemSelectedListener {
        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//            TODO("Not yet implemented")
            val selectedFontSize = intArray[p2].toFloat()
            ed1.textSize = selectedFontSize
        }

        override fun onNothingSelected(p0: AdapterView<*>?) {
//            TODO("Not yet implemented")
        }
    }

    override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
//        TODO("Not yet implemented")
        when(p1) {
            R.id.redBtn -> {
                ed1.setTextColor(Color.RED)
            }
            R.id.blueBtn -> {
                ed1.setTextColor(Color.BLUE)
            }
            R.id.greenBtn -> {
                ed1.setTextColor(Color.GREEN)
            }
        }
    }
}