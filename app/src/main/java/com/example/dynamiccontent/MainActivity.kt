package com.example.dynamiccontent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.NestedScrollView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // onClick handlers
        findViewById<Button>(R.id.button_fragment1).setOnClickListener {
            insertBlueFragment()
        }

        findViewById<Button>(R.id.button_fragment2).setOnClickListener {
            insertYellowFragment()
        }


        // by default show the blue fragment
        insertBlueFragment()
    }

    private fun adjustMinHeight(nsv: NestedScrollView, layout: ConstraintLayout) {
        layout.minHeight = nsv.scrollY + nsv.height
    }


    private fun insertYellowFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, YellowFragment())
        transaction.commit()

        val nsv = findViewById<NestedScrollView>(R.id.myScrollView)
        val layout = findViewById<ConstraintLayout>(R.id.constraintLayout)
        adjustMinHeight(nsv, layout)
    }


    private fun insertBlueFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, BlueFragment())
        transaction.commit()
    }


}
