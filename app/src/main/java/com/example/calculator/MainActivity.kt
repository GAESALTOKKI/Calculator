package com.example.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Integer.parseInt
import java.lang.NumberFormatException
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        one.setOnClickListener {
            printScreen(1)
        }

        two.setOnClickListener {
            printScreen(2)
        }

        three.setOnClickListener {
            printScreen(3)
        }

        four.setOnClickListener {
            printScreen(4)
        }

        five.setOnClickListener {
            printScreen(5)
        }

        six.setOnClickListener {
            printScreen(6)
        }

        seven.setOnClickListener {
            printScreen(7)
        }

        eight.setOnClickListener {
            printScreen(8)
        }

        nine.setOnClickListener {
            printScreen(9)
        }

        zero.setOnClickListener {
            printScreen(0)
        }

        cancle.setOnClickListener {
            screen.text = " "
        }

        div.setOnClickListener {
            printSymbol("/")
        }

        mul.setOnClickListener {
            printSymbol("*")
        }

        back.setOnClickListener {
            backPrint()
        }

        sub.setOnClickListener {
            printSymbol("-")
        }

        add.setOnClickListener {
            printSymbol("+")
        }

        enter.setOnClickListener {
            cal()
        }
    }
    fun backPrint(){
        val string = screen.text.toString()
        if(string.isNotEmpty()){
            screen.text = string.substring(0,string.length-1)
        }
    }

    fun printScreen(num: Int) {
        var previousNumber = screen.text
        var number = num.toString()
        number = "$previousNumber$number"
        screen.setText(number)
    }

    fun printSymbol(symbol: String) {
        var previousNumber = screen.text
        when (previousNumber.get(previousNumber.length - 1).toString()) {
            "*", "/", "-", "+", "" -> return
        }
        var number = symbol
        number = "$previousNumber$number"
        screen.setText(number)
    }

    fun cal(){
        try{
            val string = ExpressionBuilder(screen.text.toString()).build()
            val result = string.evaluate()
            val longResult = result.toLong()
            if(result == longResult.toDouble())
                screen.text = longResult.toString()
            else
                screen.text = result.toString()

        }catch(e:Exception){
            Log.d("Exception","message : "+e.message)
        }
    }
}