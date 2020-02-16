package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buclick(view:View){

        val buSelected= view as Button
        var buclickval:String=etshownum.text.toString()
        when (buSelected.id){

            bu0.id -> buclickval+="0"
            bu1.id -> buclickval+="1"
            bu2.id -> buclickval+="2"
            bu3.id -> buclickval+="3"
            bu4.id -> buclickval+="4"
            bu5.id -> buclickval+="5"
            bu6.id -> buclickval+="6"
            bu7.id -> buclickval+="7"
            bu8.id -> buclickval+="8"
            bu9.id -> buclickval+="9"
            budot.id -> buclickval+="." // Todo: prevent adding more than one dot
          //  budiv.id -> buclickval="÷"
          //  bumul.id -> buclickval="x"
           // busub.id -> buclickval="-"
           // buadd.id -> buclickval+="+"
           // bueql.id -> buclickval="="
              buper.id -> {
                val percent = buclickval.toDouble()
                  buclickval=(percent/100.0).toString()
              }
            busign.id -> buclickval="-$buclickval"
            buac.id->buclickval=""

        }
       etshownum.setText(buclickval)

    }
    var op:String?=null
    var num1:String?=null
    fun buopevent(view: View){

        val buSelected= view as Button
        when (buSelected.id){
            budiv.id -> op="/"
            bumul.id -> op="*"
            busub.id -> op="-"
            buadd.id -> op="+"

        }
        num1 =etshownum.text.toString()
        etshownum.setText("")
    }

    fun buequalevent(view: View){

        var num2= etshownum.text.toString()
        var total:Double?=null
        when(op){

            "/"->{
                total=num1!!.toDouble()/num2.toDouble()
            }
            "*"->{
                total=num1!!.toDouble()*num2.toDouble()
            }
            "-"->{
                total=num1!!.toDouble()-num2.toDouble()
            }
            "+"->{
                total=num1!!.toDouble()+num2.toDouble()
            }

        }
        etshownum.setText(total.toString())

    }


}
