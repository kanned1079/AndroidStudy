package com.example.myapp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class LoginDialog : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_dialog)

//        val uuuuBt = findViewById<Button>(R.id.uuuu);
//        var Intent_uuuu = Intent(this, MainActivityuuuu2::class.java);
//        uuuuBt.setOnClickListener {
//            startActivity(Intent_uuuu)
//        }
//        setContentView(R.layout.uuuu)
//        setContentView(R.layout.calculator1)

        val xh = findViewById<EditText>(R.id.ed1)
        val name = findViewById<EditText>(R.id.ed2)
        val passcode = findViewById<EditText>(R.id.ed3)
        val submitBtn = findViewById<Button>(R.id.bt1)
        val clearBtn = findViewById<Button>(R.id.bt2)
        val bt3 = findViewById<Button>(R.id.bt3)
        val showTv = findViewById<TextView>(R.id.tv1)
        var builder = AlertDialog.Builder(this)
//
        submitBtn.setOnClickListener {
            if (xh.text.isEmpty() || name.text.isEmpty() || passcode.text.isEmpty()) {
                builder.setTitle("错误")
                builder.setMessage("内容不能为空")
                builder.show()
            } else {
                Toast.makeText(this, "学号：${xh.text.toString()}\t姓名：${name.text.toString()}\t密码：${passcode.text.toString()}", Toast.LENGTH_LONG).show()
                if (xh.text.toString() == "09230630" && name.text.toString() == "shenhaiyang" && passcode.text.toString() == "passcode") {
                    builder.setTitle("登录")
                    builder.setMessage("登陆成功")
                    builder.show()
                    //Toast.makeText(this,xh.text,Toast.LENGTH_LONG).show();
                    showTv.setText("学号： " + xh.text.toString() + "\n姓名： " + name.text.toString() + "\n密码： " + passcode.text.toString())
                } else {
                    builder.setTitle("登录失败")
                    builder.setMessage("输入信息有误")
                    builder.show()
                }
            }
        }
//
//        //内部类实现
//        clearBtn.setOnClickListener(MyClick2())
//        //接口实现
//        bt3.setOnClickListener(this)


//        clearBtn.setOnClickListener {
//            xh.setText("")
//            name.setText("")
//            passcode.setText("")
//
//        }

//        val clear = findViewById<Button>(R.id.clear);
//        val del = findViewById<Button>(R.id.del);
//        val chu = findViewById<Button>(R.id.chu);
//        val chen = findViewById<Button>(R.id.x);
//        val jian = findViewById<Button>(R.id.jian);
//        val add = findViewById<Button>(R.id.add);
//        val num0 = findViewById<Button>(R.id.num0);
//        val num1 = findViewById<Button>(R.id.num1);
//        val num2 = findViewById<Button>(R.id.num2);
//        val num3 = findViewById<Button>(R.id.num3);
//        val num4 = findViewById<Button>(R.id.num4);
//        val num5 = findViewById<Button>(R.id.num5);
//        val num6 = findViewById<Button>(R.id.num6);
//        val num7 = findViewById<Button>(R.id.num7);
//        val num8 = findViewById<Button>(R.id.num8);
//        val num9 = findViewById<Button>(R.id.num9);
//        val resu = findViewById<TextView>(R.id.result1);
//
//        val builder = AlertDialog.Builder(this);
//
//        clear.setOnClickListener {
//            resu.setText("null");
//        }
//
//        var result1 = "";
//
//
//        num1.setOnClickListener {
//
//        }
//
//        var digitalCount = 0
//        var operateCount = 0
//        var allList: ArrayList<String> = ArrayList()
//        var digitals: String = ""
//
//
//        fun showContent(arrayList: ArrayList<String>) {
//            if (arrayList.size == 0) //                resu.setText("0");
//            var sb =StringBuilder();
//            for (item in arrayList) {
//                sb.append(item)
//            }
//        }


    }

//    inner class MyClick2: View.OnClickListener {
//        override fun onClick(p0: View?) {
////            TODO("Not yet implemented")
//            println("内部类 ClearBtn is clicked.")
//        }
//    }
//
    override fun onClick(p0: View?) {
//        TODO("Not yet implemented")
        println("接口 ClearBtn is clicked.")
    }
}

