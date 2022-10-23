package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var edit1 : EditText
    lateinit var edit2 : EditText
    lateinit var btnAdd : Button
    lateinit var btnSub : Button
    lateinit var btnMul : Button
    lateinit var btnDiv : Button
    lateinit var btnRem : Button
    lateinit var textResult : TextView
    lateinit var num1 :String
    lateinit var num2 :String
    var result : Double? = null
    internal var numButtons = ArrayList<Button>(10)
    internal var numBtmIDs = arrayListOf(R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2,
                                            R.id.BtnNum3, R.id.BtnNum4, R.id.BtnNum5,
                                                R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9)
    internal var I : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "초간단 계산기"

        edit1 = findViewById(R.id.Edit1)
        edit2 = findViewById(R.id.Edit2)

        btnAdd = findViewById(R.id.BtnAdd)
        btnSub = findViewById(R.id.BtnSub)
        btnMul = findViewById(R.id.BtnMul)
        btnDiv = findViewById(R.id.BtnDiv)
        btnRem = findViewById(R.id.BtnRem)

        textResult = findViewById(R.id.textResult)

        for (i in 0..9 step 1){
            numButtons.add(findViewById(numBtmIDs[i]))
        }

        for (i in 0..numBtmIDs.size-1 step 1){
            numButtons[i].setOnClickListener {
                if (edit1.isFocused){
                    num1 = edit1.text.toString() + numButtons[i].text.toString()
                    edit1.setText(num1)
                }else if (edit2.isFocused){
                    num2 = edit2.text.toString() + numButtons[i].text.toString()
                    edit2.setText(num2)
                }else{
                    Toast.makeText(applicationContext,
                                    "먼저 에디티텍스트를 선택하세요", Toast.LENGTH_SHORT).show()
                }
            }
        }

        btnAdd.setOnClickListener {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if (num1.trim () == "" || num2.trim() == "") {
                Toast.makeText(applicationContext, "입력 값이 비었습니다", Toast.LENGTH_SHORT)
                    .show()
            } else {
                result = num1.toDouble() + num2.toDouble()
                textResult.text = "계산 결과 : " + result.toString()
            }
        }

        btnSub.setOnClickListener {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if (num1.trim () == "" || num2.trim() == "") {
                Toast.makeText(applicationContext, "입력 값이 비었습니다", Toast.LENGTH_SHORT)
                    .show()
            } else {
                result = num1.toDouble() - num2.toDouble()
                textResult.text = "계산 결과 : " + result.toString()
            }
        }

        btnMul.setOnClickListener {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if (num1.trim () == "" || num2.trim() == "") {
                Toast.makeText(applicationContext, "입력 값이 비었습니다", Toast.LENGTH_SHORT)
                    .show()
            } else {
                result = num1.toDouble() * num2.toDouble()
                textResult.text = "계산 결과 : " + result.toString()
            }
        }

        btnDiv.setOnClickListener {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if (num1.trim () == "" || num2.trim() == "") {
                Toast.makeText(applicationContext, "입력 값이 비었습니다", Toast.LENGTH_SHORT)
                    .show()
            } else {
                if (num2.trim() == "0") {
                    Toast.makeText(applicationContext,
                        "0으로 나누면 안됩니다!", Toast.LENGTH_SHORT).show()
                } else {
                    result = num1.toDouble() / num2.toDouble()
                    result = (result!! * 10).toInt() / 10.0
                    textResult.text = "계산 결과 : " + result.toString()
                }
            }
        }

        btnRem.setOnClickListener {
            num1 = edit1.text.toString()
            num2 = edit2.text.toString()
            if (num1.trim () == "" || num2.trim() == "") {
                Toast.makeText(applicationContext, "입력 값이 비었습니다", Toast.LENGTH_SHORT)
                    .show()
            } else {
                if (num2.trim() == "0") {
                    Toast.makeText(applicationContext,
                        "0으로 나머지 값 안됩니다!", Toast.LENGTH_SHORT).show()
                } else {
                    result = num1.toDouble() % num2.toDouble()
                    textResult.text = "계산 결과 : " + result.toString()
                }
            }
        }
    }
}