package com.example.myapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Int64Ref
import android.view.View
import android.widget.Button
import android.widget.TextView

class Calculator : AppCompatActivity(), View.OnClickListener {
    // 可以不這麼寫
    var btID:Array<Int> ?= null // 哪怕後面是空 那麼編譯器都可以識別
    var myBtID:ArrayList<Button> ?= ArrayList()

    lateinit var dotBtn:Button
    lateinit var result:TextView
    lateinit var resultHistory:TextView

    lateinit var additionBtn:Button // +
    lateinit var subtractionBtn:Button // -
    lateinit var multiplicationBtn:Button // *
    lateinit var divisionBtn:Button // /
    lateinit var deleteBtn:Button
    lateinit var clearBtn:Button // 清除
    lateinit var calBtn:Button // 等於

    var myInput = ""
    var operateSignal = ""
    var operateNum1:Double = 0.0
    var operateNum2:Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        btID = arrayOf(
            R.id.num0,
            R.id.num1,
            R.id.num2,
            R.id.num3,
            R.id.num4,
            R.id.num5,
            R.id.num6,
            R.id.num7,
            R.id.num8,
            R.id.num9
        )
        // 書上p63有遍歷數組的寫法
        for (i in btID!!.indices) {
            myBtID!!.add(i, findViewById(btID!![i])) // 綁定控件ID
            myBtID!![i].setOnClickListener(this) // 綁定事件
        }

        // sig
        dotBtn = findViewById(R.id.dot)
        // function btns
        result = findViewById(R.id.result1)
        additionBtn = findViewById(R.id.add)
        subtractionBtn = findViewById(R.id.jian)
        multiplicationBtn = findViewById(R.id.x)
        divisionBtn = findViewById(R.id.chu)
        clearBtn = findViewById(R.id.clear)
        calBtn = findViewById(R.id.calRes)
        deleteBtn = findViewById(R.id.delFunc)
        resultHistory = findViewById(R.id.resultHistory)

        // Add actions
        dotBtn.setOnClickListener(this)
        additionBtn.setOnClickListener(this)
        subtractionBtn.setOnClickListener(this)
        multiplicationBtn.setOnClickListener(this)
        divisionBtn.setOnClickListener(this)
        clearBtn.setOnClickListener(this)
        deleteBtn.setOnClickListener(this)
        calBtn.setOnClickListener(this)
    }

    fun startCal() {
        resultHistory.text = myInput.toString()
        var _myNumsList = myInput.split(Regex("[-,+,*,/]"))
        println(_myNumsList)
        println(_myNumsList.size)
        operateNum1 = _myNumsList.elementAt(0).toDouble()
        operateNum2 = _myNumsList.elementAt(1).toDouble()
        println("操作數：${operateNum1}, ${operateNum2}")
        if (operateSignal.equals("+")) {
            result.text = operateNum1.plus(operateNum2).toString()
        } else if (operateSignal.equals("-")) {
            result.text = operateNum1.minus(operateNum2).toString()
        } else if (operateSignal.equals("*")) {
            result.text = operateNum1.times(operateNum2).toString()
        } else if (operateSignal == "/") {
            result.text = operateNum1.div(operateNum2).toString()
        } else {
            result.text = "ERROR"
        }
    }

    fun deleteNums() {
        myInput = myInput.subSequence(0, myInput.length - 1).toString()
        result.text = myInput;
    }

    fun clearNums() {
        myInput = ""
        result.text = myInput
        resultHistory.text = ""

    }

    override fun onClick(p0: View?) {
//        TODO("Not yet implemented")
        when (p0?.id) {
            // 數字按鍵
            R.id.num0 -> { myInput += "0"; result.text = myInput}
            R.id.num1 -> { myInput += "1"; result.text = myInput}
            R.id.num2 -> { myInput += "2"; result.text = myInput}
            R.id.num3 -> { myInput += "3"; result.text = myInput}
            R.id.num4 -> { myInput += "4"; result.text = myInput}
            R.id.num5 -> { myInput += "5"; result.text = myInput}
            R.id.num6 -> { myInput += "6"; result.text = myInput}
            R.id.num7 -> { myInput += "7"; result.text = myInput}
            R.id.num8 -> { myInput += "8"; result.text = myInput}
            R.id.num9 -> { myInput += "9"; result.text = myInput}
            // 功能按鍵
            R.id.dot -> { myInput += ".";result.text = myInput }
            R.id.add -> { myInput += "+"; result.text = myInput; operateSignal = "+" }
            R.id.jian -> { myInput += "-"; result.text = myInput; operateSignal = "-" }
            R.id.x -> { myInput += "*"; result.text = myInput; operateSignal = "*" }
            R.id.chu -> { myInput += "/"; result.text = myInput; operateSignal = "/" }
            // 操作
            R.id.delFunc -> { deleteNums() }
            R.id.clear -> { clearNums() }
            // 計算邏輯實現
            R.id.calRes -> { startCal() }
        }
    }
}